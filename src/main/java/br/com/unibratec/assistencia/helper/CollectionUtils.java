package br.com.unibratec.assistencia.helper;

import java.util.Collection;

public class CollectionUtils {

	public static boolean isNullOrEmpty(Collection<?> list) {
		return list == null || list.isEmpty();
	}

}
