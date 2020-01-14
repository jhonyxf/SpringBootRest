package br.com.sbr.erudio.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <D, O> D parseObject(O origin, Class<D> destination){
		return mapper.map(origin, destination);
	}
	
	public static <D, O> List<D> parseListObjects(List<O> origin, Class<D> destination){
		List<D> destinationObjects = new ArrayList<D>();
		for (Object o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}

}
