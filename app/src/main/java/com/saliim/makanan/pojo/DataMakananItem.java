package com.saliim.makanan.pojo;

import com.google.gson.annotations.SerializedName;

public class DataMakananItem{

	@SerializedName("foto_makanan")
	private String fotoMakanan;

	@SerializedName("insert_time")
	private String insertTime;

	@SerializedName("makanan")
	private String makanan;

	public void setFotoMakanan(String fotoMakanan){
		this.fotoMakanan = fotoMakanan;
	}

	public String getFotoMakanan(){
		return fotoMakanan;
	}

	public void setInsertTime(String insertTime){
		this.insertTime = insertTime;
	}

	public String getInsertTime(){
		return insertTime;
	}

	public void setMakanan(String makanan){
		this.makanan = makanan;
	}

	public String getMakanan(){
		return makanan;
	}

	@Override
 	public String toString(){
		return 
			"DataMakananItem{" + 
			"foto_makanan = '" + fotoMakanan + '\'' + 
			",insert_time = '" + insertTime + '\'' + 
			",makanan = '" + makanan + '\'' + 
			"}";
		}
}