package br.com.salasagendamento.model.messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MensagemInternacionalizadaImpl implements MensagemInternacionalizada {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key) {
        return getMessage(key, null);
    }

    public String getMessage(String key, Object... objects) {
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(key, locale, objects);
    }

    public String getMessage(String key, Locale locale, Object... objects) {
        try {
            return messageSource.getMessage(key, objects, locale);
        } catch (NoSuchMessageException ex){
        	return "Ocorreu um erro: " + ex;
        }
    }
}
