package com.ruan;

import com.google.gson.GsonBuilder;
import com.ruan.blockchain.Block;


import java.util.ArrayList;


public class App
{
    public static ArrayList<Block> blockChain = new ArrayList<Block>();

    public static Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;

        for(int i = 0; i< blockChain.size(); i++){
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current hashes not equal at "+i);
                return false;
            }
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous hashes not equal at"+i);
                return false;
            }
        }
        return true;
    }

    public static void main( String[] args )
    {

        blockChain.add(new Block("Eu sou o primeiro bloco", "0"));
        blockChain.add(new Block("Sou o segundo bloco",blockChain.get(blockChain.size()-1).hash));
        blockChain.add(new Block("Sou o terceiro bloco",blockChain.get(blockChain.size()-1).hash));

        String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockChainJson);



    }

}
