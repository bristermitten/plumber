package me.bristermitten.plumber.struct.extension;

public interface Extendable<E extends Extendable<E>> {

    <T extends Extension<E>> T getExtension(Class<T> clazz);
}
