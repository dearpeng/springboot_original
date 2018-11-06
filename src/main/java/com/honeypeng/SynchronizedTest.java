// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SynchronizedTest.java

package com.honeypeng;

import java.io.PrintStream;

public class SynchronizedTest
{

	public SynchronizedTest()
	{
	}

	public synchronized void doSth()
	{
		System.out.println("Hello World");
	}

	public void doSth1()
	{
		synchronized (SynchronizedTest.class)
		{
			System.out.println("Hello World");
		}
	}
}
