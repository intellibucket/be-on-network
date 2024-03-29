INSERT INTO replica.countries (uuid, version, process_status, row_status, created_date, modification_date, name, code,
                               phone_code, currency, currency_code, currency_symbol, flag, flag_url, timezone,
                               timezone_offset, latitude, longitude)
VALUES (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE', now(), null, 'Turkey', 'TR', '+90', 'Turkish Lira', 'TRY', '₺',
        null, 'https://www.worldometers.info//img/flags/small/tn_tu-flag.gif', 'Europe/Istanbul', '+3:00', 39.9334,
        32.8597),
       (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE', now(), null, 'United States', 'US', '+1', 'United States Dollar',
        'USD', '$', null, 'https://www.worldometers.info//img/flags/small/tn_us-flag.gif', 'America/New_York', '-5:00',
        37.7749, -122.4194),
       (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE', now(), null, 'Saudi Arabia', 'SA', '+966', 'Saudi Riyal', 'SAR',
        'ر.س', null, 'https://www.worldometers.info//img/flags/small/tn_sa-flag.gif', 'Asia/Riyadh', '+3:00', 24.7136,
        46.6753),
       (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE', now(), null, 'Azerbaijan', 'AZ', '+994', 'Azerbaijani Manat',
        'AZN', '₼', null, 'https://www.worldometers.info//img/flags/small/tn_aj-flag.gif', 'Asia/Baku', '+4:00',
        40.4093, 49.8671),
       (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE', now(), null, 'England', 'EN', '+44', 'Pound Sterling', 'GBP', '£',
        null, 'https://www.worldometers.info//img/flags/small/tn_uk-flag.gif', 'Europe/London', '+0:00', 51.5099,
        -0.1180),
       (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE', now(), null, 'Spain', 'ES', '+34', 'Euro', 'EUR', '€', null,
        'https://example.com/flags/es.png', 'Europe/Madrid', '+1:00', 40.4168, -3.7038),
       (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE', now(), null, 'Chine', 'CN', '+86', 'Renminbi', 'CNY', '¥', null,
        'https://example.com/flags/cn.png', 'Asia/Shanghai', '+8:00', 31.2304, 121.4737),
       (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE', now(), null, 'French', 'FR', '+33', 'Euro', 'EUR', '€', null,
        'https://example.com/flags/fr.png', 'Europe/Paris', '+1:00', 48.8566, 2.3522),
       (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE', now(), null, 'Hindi', 'IN', '+91', 'Indian Rupee', 'INR', '₹',
        null, 'https://example.com/flags/in.png', 'Asia/Kolkata', '+5:30', 28.6139, 77.2090);

