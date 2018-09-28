package br.com.salasagendamento.model.messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MessageSourceServiceImpl implements Message {

    @Autowired
    private MensagemInternacionalizada messages;

    public String getMessage(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return messages.getMessage(key, locale, null);
    }

    public String getMessage(String key, Object... objects) {
        Locale locale = LocaleContextHolder.getLocale();
        return messages.getMessage(key, objects, locale);
    }

    public String getMessage(String key, Locale locale) {
        return messages.getMessage(key, null, locale);
    }

}
