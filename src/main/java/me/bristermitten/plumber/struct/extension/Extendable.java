package me.bristermitten.plumber.struct.extension;

public interface Extendable {

    <T extends Extension> T getExtension(Class<T> clazz);
}
