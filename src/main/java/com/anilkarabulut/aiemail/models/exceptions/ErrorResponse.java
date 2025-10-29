package com.anilkarabulut.aiemail.models.exceptions;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * API'den dönen standart hata yanıtı formatı.
 * @param statusCode HTTP status kodu (örn: 404)
 * @param message Kullanıcıya gösterilecek genel hata mesajı
 * @param details Geliştirici için teknik detay veya validasyon hataları
 * @param path Hatayı tetikleyen API yolu
 * @param timestamp Hatanın oluşma zamanı
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // Sadece dolu olan alanları JSON'a dahil et
public record ErrorResponse(
        int statusCode,
        String message,
        Object details, // Validasyon hataları için Map<String, String> veya genel hata için String
        String path,
        LocalDateTime timestamp
) {
    // Validasyon hataları için yardımcı constructor
    public ErrorResponse(int statusCode, String message, Map<String, String> validationErrors, String path) {
        this(statusCode, message, validationErrors, path, LocalDateTime.now());
    }

    // Genel hatalar için yardımcı constructor
    public ErrorResponse(int statusCode, String message, String details, String path) {
        this(statusCode, message, details, path, LocalDateTime.now());
    }
}