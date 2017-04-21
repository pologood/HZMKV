package com.hazelcast.webmonitor.enterprise;

public class License
{
    public final boolean full;
    public final boolean enterprise;
    public final int day;
    public final int month;
    public final int year;
    public final int nodes;

    License(boolean full, boolean enterprise, int day, int month, int year, int nodes)
    {
        this.full = full;
        this.enterprise = enterprise;
        this.day = day;
        this.month = month;
        this.year = year;
        this.nodes = nodes;
    }

    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }
        License license = (License)o;
        if (this.day != license.day) {
            return false;
        }
        if (this.enterprise != license.enterprise) {
            return false;
        }
        if (this.full != license.full) {
            return false;
        }
        if (this.month != license.month) {
            return false;
        }
        if (this.nodes != license.nodes) {
            return false;
        }
        if (this.year != license.year) {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        int result = this.full ? 1 : 0;
        result = 31 * result + (this.enterprise ? 1 : 0);
        result = 31 * result + this.day;
        result = 31 * result + this.month;
        result = 31 * result + this.year;
        result = 31 * result + this.nodes;
        return result;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("License");
        sb.append("{full=").append(this.full);
        sb.append(", enterprise=").append(this.enterprise);
        sb.append(", day=").append(this.day);
        sb.append(", month=").append(this.month);
        sb.append(", year=").append(this.year);
        sb.append(", nodes=").append(this.nodes);
        sb.append('}');
        return sb.toString();
    }
}
