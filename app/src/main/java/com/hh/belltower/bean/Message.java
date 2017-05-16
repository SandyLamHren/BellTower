package com.hh.belltower.bean;

public class Message {
    private String sender;
    private String receiverValue;
    private String content;
    private String time;
    private String checked;
    private int receiverType;
    private int readAmount;
    private String msgId;

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public int getReadAmount() {
        return this.readAmount;
    }

    public void setReadAmount(int readAmount) {
        this.readAmount = readAmount;
    }

    public String getReceiverValue() {
        return this.receiverValue;
    }

    public void setReceiverValue(String receiverValue) {
        this.receiverValue = receiverValue;
    }

    public int getReceiverType() {
        return this.receiverType;
    }

    public void setReceiverType(int receiverType) {
        this.receiverType = receiverType;
    }

    public String getChecked() {
        return this.checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Message(String sender, String receiverValue, String content, String time, String checked, int receiverType, int readAmount, String msgId) {
        this.sender = sender;
        this.receiverValue = receiverValue;
        this.content = content;
        this.time = time;
        this.checked = checked;
        this.receiverType = receiverType;
        this.readAmount = readAmount;
        this.msgId = msgId;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", receiverValue='" + receiverValue + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", checked='" + checked + '\'' +
                ", receiverType=" + receiverType +
                ", readAmount=" + readAmount +
                ", msgId='" + msgId + '\'' +
                '}';
    }
}