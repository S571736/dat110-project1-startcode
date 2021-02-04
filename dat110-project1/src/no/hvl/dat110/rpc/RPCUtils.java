package no.hvl.dat110.rpc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

    // Utility methods for marshalling and marshalling of parameters and return values
    // in RPC request and RPC responses
    // data bytearrays and return byte arrays is according to the
    // RPC message syntax [rpcid,parameter/return value]

    public static byte[] marshallString(byte rpcid, String str) {

        byte[] encoded;


        encoded = new byte[str.length()+1];
        encoded[0] = rpcid;

        for (int i = 0; i < str.length(); i++) {
            encoded[i + 1] = (byte) str.charAt(i);
        }

        return encoded;
    }

    public static String unmarshallString(byte[] data) {

        String decoded;

        decoded = new String(data, StandardCharsets.UTF_8);

        decoded = decoded.substring(1);


        return decoded;
    }

    public static byte[] marshallVoid(byte rpcid) {


        byte[] encoded = new byte[1];

        encoded[0] = rpcid;

        return encoded;

    }

    public static void unmarshallVoid(byte[] data) {


        return;
        // TODO: unmarshall void type - Excuse me wtf?
    }

    public static byte[] marshallBoolean(byte rpcid, boolean b) {

        byte[] encoded = new byte[2];

        encoded[0] = rpcid;

        if (b) {
            encoded[1] = 1;
        } else {
            encoded[1] = 0;
        }

        return encoded;
    }

    public static boolean unmarshallBoolean(byte[] data) {

        return (data[1] > 0);

    }

    public static byte[] marshallInteger(byte rpcid, int x) {

        byte[] encoded;

        encoded = new byte[2];

        encoded[0] = rpcid;
        encoded[1] = (byte) x;

        return encoded;
    }

    public static int unmarshallInteger(byte[] data) {

        int decoded;

        decoded = data[1] & 0xFF;

        return decoded;

    }
}
