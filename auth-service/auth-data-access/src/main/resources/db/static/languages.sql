INSERT INTO replica.languages
(uuid, version, process_status, row_status, created_date, modification_date, name, iso_code, region, script, family, native_name, native_region)
VALUES
    (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE',now(),null,'Azerbaijani', 'az', 'Azerbaijan', 'Latin', 'Turkic', 'Azərbaycan dili', 'Azərbaycan'),
    (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE',now(),null,'Turkish', 'tr', 'Turkey', 'Latin', 'Turkic', 'Türkçe', 'Türkiye'),
    (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE',now(),null,'English', 'en', 'United States', 'Latin', 'Indo-European', 'English', 'United States'),
    (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE',now(),null,'Arabic', 'ar', 'Middle East, North Africa', 'Arabic', 'Afroasiatic', 'عربي', 'الوطن العربي'),
    (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE',now(),null,'Spanish', 'es', 'Spain, Latin America', 'Latin', 'Indo-European', 'Español', 'Spain, Latin America'),
    (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE',now(),null,'Chinese', 'zh', 'China, Southeast Asia', 'Chinese', 'Sino-Tibetan', '中文', '中国，东南亚'),
    (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE',now(),null,'French', 'fr', 'France, Africa, Canada', 'Latin', 'Indo-European', 'Français', 'France, Africa, Canada'),
    (gen_random_uuid(), 1, 'COMPLETED', 'ACTIVE',now(),null,'Hindi', 'hi', 'India', 'Devanagari', 'Indo-European', 'हिन्दी', 'भारत');
