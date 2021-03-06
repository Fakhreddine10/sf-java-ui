package io.asfjava.ui.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.asfjava.ui.core.schema.decorator.SchemaDecorator;

public final class SchemaDecoratorFactory {
	public SchemaDecorator getGenerator(String annotationName) {
		return decorators.get(annotationName);
	}

	void register(String annotationName, SchemaDecorator generator) {
		decorators.put(annotationName, generator);
	}

	public static SchemaDecoratorFactory getInstance() {
		if (instance == null) {
			instance = new SchemaDecoratorFactory();
		}
		return instance;
	}

	private static final Map<String, SchemaDecorator> decorators = new ConcurrentHashMap<>();

	private static SchemaDecoratorFactory instance;

	private SchemaDecoratorFactory() {
	}
}
