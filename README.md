# Проект по автоматизации тестовых сценариев для сайта компании [Цифра Брокер](https://cifra-broker.ru/)
Цифра Брокер — является одной из ведущих российских инвестиционных компаний, работает на фондовом рынке с 2010 года, является участником торгов Московской Биржи и СПБ Биржи.

## :pushpin: Содержание:

- [Используемый стек](#-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео пример запуска тестов](#-видео-пример-запуска-тестов)
## &#129470; Используемый стек

<p align="center">
<a href="https://www.jetbrains.com/">
<img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg">
</a>
<a href="https://www.java.com/">
<img width="6%" title="Java" src="media/logo/Java.svg">
</a>
<a href="https://ru.selenide.org/">
<img width="6%" title="Selenide" src="media/logo/Selenide.svg">
</a>
<a href="https://aerokube.com/selenoid/latest/">
<img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
</a>
<a href="https://docs.qameta.io/allure/">
<img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg">
</a>
<a href="https://qameta.io/">
<img width="5%" title="Allure TestOps" src="media/logo/AllureTestOps.svg">
</a>
<a href="https://gradle.org/">
<img width="6%" title="Gradle" src="media/logo/Gradle.svg">
</a>
<a href="https://junit.org/junit5/">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
</a>
<a href="https://github.com/">
<img width="6%" title="GitHub" src="media/logo/GitHub.svg">
</a>
<a href="https://www.jenkins.io/">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
</a>
<a href="https://web.telegram.org/">
<img width="6%" title="Telegram" src="media/logo/Telegram.svg">
</a>
<a href="https://www.atlassian.com/ru/software/jira">
<img width="5%" title="Jira" src="media/logo/Jira.svg">
</a>
</p>

- Тесты в проекте написаны на языке <code>Java</code> с использованием фреймворка <code>Selenide</code>
- В качестве сборщика использован - <code>Gradle</code>
- В качестве фреймворка модульного тестирования задействован <code>JUnit 5</code>
- При удаленном прогоне тестов браузер запускается в <code>Selenoid</code>
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>


## :arrow_forward: Запуск автотестов
### Варианты запуска тестов
- ```test``` — Запуск всех тестов
- ```smoke_test``` — Запуск тестов smoke
- ```main_page_test``` — Запуск тестов Главной страницы
- ```main_page_test``` — Запуск тестов с Переходом на другие страницы компании
### Запуск тестов локально из терминала
```
gradle clean test
```

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> [Сборка в Jenkins](https://jenkins.autotests.cloud/job/cifra_broker/)
### Параметры сборки
* <code>BROWSER</code> — выбор браузера. Значение по-умолчанию — <code>chrome</code>.
* <code>BROWSER_VERSION</code> — версия браузера. Значение по-умолчанию — <code>100.0</code>.
* <code>BROWSER_SIZE</code> — размер окна браузера. Значение по-умолчанию — <code>1920x1080</code>.
* <code>BASE_URL</code> – url, по которому будет открываться тестируемое приложение. По-умолчанию - <code>https://cifra-broker.ru/</code>.
* <code>SELENOID_URL</code> – адрес удалённого браузера.
* <code>SELENOID_LOGIN</code> – логин для удаленного запуска тестов.
* <code>SELENOID_PASSWORD</code> – пароль для удаленного запуска тестов.

<p align="center">
<img title="Jenkins Build" src="media/screens/JenkinsBuild.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> [Пример Allure-отчета](https://jenkins.autotests.cloud/job/cifra_broker/39/allure/)
<p align="center">
<img title="Allure Overview" src="media/screens/AllureOverview.png">
</p>

### Результат выполнения теста
Содержание:
* Шаги теста
* Скриншот страницы на последнем шаге
* Page Source
* Логи браузерной консоли
* Видео прогона автотестов

<p align="center">
<img title="Test Results in Alure" src="media/screens/AllureSuites.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> [Интеграция с Allure TestOps](https://allure.autotests.cloud/project/3448/launches)
На вкладке <code>Dashboards</code> отображается:
- Количество тест-кейсов и их статус
- Соотношение ручных/автоматизированных тестов
- Результаты запусков/прохождения тестов в графике по датам
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/AllureDashboards.png">
</p>

На вкладке <code>Launches</code> можно увидеть:
- Результаты запусков автоматизированных тестов
- Результаты прохождения ручных тест-кейсов
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/LaunchesTestOps.png">
</p>

Результаты выполнения отдельных тестов:
* Шаги теста
* Скриншот страницы на последнем шаге
* Page Source
* Логи браузерной консоли
* Видео прогона автотестов

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/AllureTestCases.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> [Интеграция с Jira](https://jira.autotests.cloud/browse/HOMEWORK-770)
Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>. В задаче отображаются прикреплённые к ней тест-кейсы, а также результаты запусков/прохождения тестов.
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/Jira.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram
После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/Telegram.png" width="50%" height="50%">

</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео пример запуска теста с загрузкой файла в формате .pdf
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>