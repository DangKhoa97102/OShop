package com.oshop.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.data.domain.Page;

public class MapperUtils {
	
	private static final ModelMapper modelMapper;

	static {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	private MapperUtils() {
		
	}
	
	public static <D, T> D map(final T entity, Class<D> outclass) {
		return modelMapper.map(entity, outclass);
	}
	
	public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outClass) {
		return entityList.stream().map(entity -> map(entity, outClass)).collect(Collectors.toList());
	}
	
	public static <D, T> Page<D> mapAll(final Page<T> entityPage, Class<D> outClass) {
		return entityPage.map(entity -> map(entity, outClass));
	}
	
    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}
