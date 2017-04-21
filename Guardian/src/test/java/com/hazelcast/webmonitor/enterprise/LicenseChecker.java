package com.hazelcast.webmonitor.enterprise;

public class LicenseChecker
{
    protected static final char[] chars = "QRSTUVWXYZ6789ABCDEFGHIJKLMNOP".toCharArray();
    protected static final char[] digits = "0123456789".toCharArray();
    protected static final int length = chars.length;
    protected static final int reserved = 12;
    protected static final int yearBase = 2010;

    public static License extractLicense(char[] originalKey)
    {
        if ((originalKey == null) || (length != originalKey.length)) {
            throw new IllegalArgumentException("Invalid key!");
        }
        char[] key = new char[length];
        System.arraycopy(originalKey, 0, key, 0, length);
        char fp = key[11];
        key[11] = '\000';
        char lp = key[12];
        key[12] = '\000';

        char[] hash = hash(key);
        if ((hash[0] != fp) || (hash[(hash.length - 1)] != lp)) {
            throw new IllegalArgumentException("Invalid key!");
        }
        int ix = 0;
        char r = key[(ix++)];
        boolean full = key[ix0(r)] == '1';

        char t = key[(ix++)];
        boolean enterprise = key[ix0(t)] == '1';

        char d0 = key[(ix++)];
        char d1 = key[(ix++)];
        int day = ix1(key[ix0(d0)]) * 10 + ix1(key[ix0(d1)]);

        char m0 = key[(ix++)];
        char m1 = key[(ix++)];
        int month = ix1(key[ix0(m0)]) * 10 + ix1(key[ix0(m1)]);

        char y = key[(ix++)];
        int year = 2010 + ix1(key[ix0(y)]);

        char n0 = key[(ix++)];
        char n1 = key[(ix++)];
        char n2 = key[(ix++)];
        char n3 = key[(ix++)];
        int nodes = ix1(key[ix0(n0)]) * 1000 + ix1(key[ix0(n1)]) * 100 + ix1(key[ix0(n2)]) * 10 + ix1(key[ix0(n3)]);

        return new License(full, enterprise, day, month, year, nodes);
    }

    private static int ix0(char c)
    {
        return ix(chars, c);
    }

    private static int ix1(char c)
    {
        return ix(digits, c);
    }

    private static int ix(char[] cc, char c)
    {
        for (int i = 0; i < cc.length; i++) {
            if (c == cc[i]) {
                return i;
            }
        }
        return -1;
    }

    protected static char[] hash(char[] a)
    {
        if (a == null) {
            return new char[] { '0' };
        }
        int result = 1;
        for (char element : a) {
            result = 31 * result + element;
        }
        return Integer.toString(Math.abs(result)).toCharArray();
    }
}
