package com.dotest.we.utils;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.hibernate.Hibernate;

import com.mysql.jdbc.Blob;

public class BlobUtils {

	/**
	 * 
	 * 把Blob类型转换为byte数组类型
	 * 
	 * @param blob
	 * 
	 * @return
	 * 
	 */

	private byte[] blobToBytes(Blob blob) {
	
		BufferedInputStream is = null;
		
		
	
		
		try {

			is = new BufferedInputStream(blob.getBinaryStream());

			byte[] bytes = new byte[(int) blob.length()];

			int len = bytes.length;

			int offset = 0;

			int read = 0;

			while (offset < len && (read = is.read(bytes, offset, len - offset)) >= 0) {

				offset += read;

			}

			return bytes;

		} catch (Exception e) {

			return null;

		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
