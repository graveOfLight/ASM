package com.asm.util;

import java.io.Serializable;


public class NonReferenceArrayList implements Serializable
{
	public static interface Listener
	{
		public Object copyOf(Object arr, int len);
	}
	
	
	private int len;
	private Object arr;
	transient private Listener l;
	
	// TODO : catch wrong index bound and throw exception
	
	public NonReferenceArrayList(Object arr, int len) {
		this(arr, len, null);
	}
	
	public NonReferenceArrayList(Object arr, int len, Listener l) {
		this.arr = arr;
		this.len = len;
		this.l = l;
	}
	
	public void insert(int where, Object data, int start, int end) {
		int dataLen = end - start;
		arr = l.copyOf(arr, len + dataLen);
		System.arraycopy(arr, where, arr, where + dataLen, len - where + dataLen);
		System.arraycopy(data, start, arr, where, len);
		len += dataLen;
	}
	
	public void append(Object data, int start, int end) {
		int dataLen = end - start;
		arr = l.copyOf(arr, len + dataLen);
		System.arraycopy(data, start, arr, len, dataLen);
		len += dataLen;
	}
	
	public void delete(int start, int end) {
		int dataLen = end - start;
		System.arraycopy(arr, end, arr, start, len - end);
		arr = l.copyOf(arr, len - dataLen);
		len -= dataLen;
	}
	
	public Object get() {
		return arr;
	}
	
	public int length() {
		return len;
	}
	
	public void clear() {
		arr = l.copyOf(arr, 0);
	}
	
	public void setListener(Listener l) {
		this.l = l;
	}
}
