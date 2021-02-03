package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		byte[] request = RPCUtils.marshallString(RPCID, message);
		byte[] reply = rpcclient.call(request);

		String temp = RPCUtils.unmarshallString(reply);

		System.out.println(temp);


		// implement marshalling, call and unmarshalling for write RPC method

	}
}
