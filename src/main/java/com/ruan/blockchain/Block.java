package com.ruan.blockchain;
import com.ruan.util.StringUtil;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;


    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash(){
        String calculatedHash = StringUtil.applySha256(
                this.previousHash +
                        Long.toString(this.timeStamp)+
                        data);
        return calculatedHash;
    }
}
