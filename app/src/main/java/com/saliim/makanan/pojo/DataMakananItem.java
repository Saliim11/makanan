package com.saliim.makanan.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataMakananItem implements Parcelable {

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.fotoMakanan);
		dest.writeString(this.insertTime);
		dest.writeString(this.makanan);
	}

	public DataMakananItem() {
	}

	protected DataMakananItem(Parcel in) {
		this.fotoMakanan = in.readString();
		this.insertTime = in.readString();
		this.makanan = in.readString();
	}

	public static final Parcelable.Creator<DataMakananItem> CREATOR = new Parcelable.Creator<DataMakananItem>() {
		@Override
		public DataMakananItem createFromParcel(Parcel source) {
			return new DataMakananItem(source);
		}

		@Override
		public DataMakananItem[] newArray(int size) {
			return new DataMakananItem[size];
		}
	};
}