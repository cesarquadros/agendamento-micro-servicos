package br.com.salasagendamento.messages;

import java.util.Locale;

public interface Message {

	String getMessage(String key);
    String getMessage(String key, Object... objects);
    String getMessage(String key, Locale locale);
}
