package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;


public class Message {

	private byte[] payload;

	public Message(byte[] payload)
	{
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData()
	{
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = new byte[128];
		byte size = (byte)this.payload.length;



		encoded[0] = size;
		for (int i = 0; i < size ; i++) {
			encoded[i+1] = this.payload[i];
		}

		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format




		return encoded;

	}

	public void decapsulate(byte[] received) {

		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message

		this.payload = new byte[received[0]];
		for (int i = 0; i < received[0]; i++) {
			this.payload[i]=received[i+1];
		}
		
	}
}
