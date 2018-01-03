package com.syne.weakref.javaspecialist;

public class LargeObject {
	  private final byte[] space = new byte[1024 * 1024];
	  private final int id;
	  public LargeObject(int id) {
	    this.id = id;
	  }
	  public int getId() {
	    return id;
	  }
	  @Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		
		System.out.println("------------finalize--------------");
	}
	}

