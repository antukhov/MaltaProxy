package com.malta.proxy;

import java.util.Date;
import java.util.Objects;

public class InboundHTTPRequestEntity {
    private final Date createdAt;
    private final String IPAddress;
    private final String bodyPayload;
    private final String threadNumber;

    public InboundHTTPRequestEntity(String IPAddress, String bodyPayload, String threadNumber) {
        this.createdAt = new Date();
        this.IPAddress = IPAddress;
        this.bodyPayload = bodyPayload;
        this.threadNumber = threadNumber;
    }

    public Date getCreatedAt() { return createdAt; }

    public String getIPAddress() {
        return IPAddress;
    }

    public String getBodyPayload() {
        return bodyPayload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InboundHTTPRequestEntity that = (InboundHTTPRequestEntity) o;
        if (!IPAddress.equals(that.IPAddress)) return false;
        return Objects.equals(bodyPayload, that.bodyPayload);
    }

    @Override
    public int hashCode() {
        int result = createdAt.hashCode();
        result = 31 * result + IPAddress.hashCode();
        result = 31 * result + (bodyPayload != null ? bodyPayload.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InboundHTTPRequestEntity{" +
                "createdAt=" + createdAt +
                ", IPAddress='" + IPAddress + '\'' +
                ", bodyPayload='" + bodyPayload + '\'' +
                ", threadNumber='" + threadNumber + '\'' +
                '}';
    }
}
