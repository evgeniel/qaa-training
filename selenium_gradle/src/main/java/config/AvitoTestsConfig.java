package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с конфигурацией проекта для тестов Авито страницы
 */
@Config.Sources({"classpath:avito_tests_config.properties"})
public interface AvitoTestsConfig extends Config {

    /**
     * Метод возвращает параметр regionInputField из avito_tests_config.properties
     *
     * @return параметр атрибута региона
     */
    String regionInputField();

    /**
     * Метод возвращает параметр searchInput из avito_tests_config.properties
     *
     * @return параметр строки поиска
     */
    String inputSearch();
}
