package com.service.multipleregression;

import java.util.List;

/**
 *
 * @author conta
 */
public class DataInput {

	IReader read = null;

	public DataInput(IReader reader) {
		this.read = reader;
	}

	public List<String[]> inputReader(String splitBy) {
		return read.inputReader(splitBy);
	}

}