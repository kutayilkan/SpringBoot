package com.hoodzie.springbootstart.internatilized;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping(value = "i18n")
@Tag(name = "I18N Controller", description = "Accept-Header en_tr")
public class I18NController {

    private MessageSource messageSource;

    public I18NController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public String goodMorningI18N() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

    }
}
