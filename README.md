# Magnificent
Целью моего курсового проекта стала разработка клиент-серверного приложения, позволяющего автоматизировать бронирование мест в кинотеатрах. Помимо этого, данное приложение позволяет просматривать актуальные фильмы доступные на текущий момент. При бронировании билета приложение предоставит полный список кинотеатров и сеансов доступных для данного фильма. Также позволит просматривать забронированные билеты в удобной форме. 
<p>Приложение разработано на Android Java. Сервер разработан на ASP.NET Core. Для хранения данных используется MS SQL Server.</p>
<p>Основные функции выполняемые приложением:</p>

* выбор кинотеатра и даты сеанса
* удобный выбор мест на сеанс
* удобная форма для просмотра купленных билетов
* полноценная регистрация с авторизацией
* возможность оставить отзыв
* подробное описание фильмов и их рейтинг
* просмотр отзывов к фильмам
* добавление, удаление и редактирование фильмов
* добавление, удаление и редактирование кинотеатров
* добавление, удаление и редактирование залов
* добавление сеансов

При запуске приложения будет происходить анимация и открытие окна авторизации.

<p align="center">
  <img src="https://lh3.googleusercontent.com/pw/ACtC-3fgm3XnoyuIvc7syedWTHNMld9eOrIqWk02lDw7TxshdrbJEhFx7Vd95VoLphhKGNJ1kJSIU3rSB7Yn-4oa0Kws6ikN48AGB3vKLXZprb6pGWA7zaCytH9TkUmMkQ3l8sLCIoX3xhLmu0PcJ2NL8eyO=w373-h705-no?authuser=0" width="350" title="Login">
</p>
 
<p>Через него будет осуществляться вход в приложение. Для авторизации требуется ввести логин и пароль. Имеется валидация логина и пароля. Для того чтобы просмотреть введенный пароль имеется ползунок "Показать пароль". В случае успешной авторизации, в зависимости от роли, пользователь перейдет к окну, где отображается слайдер с доступными фильмами, менеджер, к окну менеджера. </p>
<p>В окне авторизации, а также окне регистрации присутствует ограничение на невозможность создания скриншотов экрана. Если пользователь не зарегестрирован он может перейти к окну регистрации нажав на "У меня нет аккаунта".</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/jcjjABkWJT6xggZUJNpk0i9bLzZfdrSYNYSdxEXeA_J6L1lTXsiJ9hojRugLKwOh-Q4sGK01rUIHPp6f6_ajF1k5yiIH6WoP1X3sS88HVZGYzkKuPcfunmvunFHHizRor4aOdWw_hZcclIEn4PzsCOBewcZemcBXIzzai4jh6njqbdhR0ZCGTbiHpVChc9owPlZ-3vnC9QsOGs7XPyvTXR8S8BfarPe9V13Y1HUNtRg2tnZm67ctoFiwEzL6EPqSXqWI8ThjHqAgMHlz2q6w9dptmyjNfXINrEShSVdj1ciTIqqBXEtImi4o_lmc3Wnv_Ro_f2n18WJsT7u0rfc7uhNndoaLK255tvSZjmy6XhLMU22Zp6LXI5gyD9gPJ5Ux01xaKNeoVzH7FTUUEN9a0E3VycaiTZbfAoksAyh-s9pfQDhuInAUlU6SwJ23HfIoaNkN_TELO9emqo9eM9xvWeKP-ZbEgfKOcauZp4RhI7pv4oa9eJcara8GW_YNe8bB0Bx49u9WCiJrAlE36b3LspUWXLiC3L1MO_bhqvREvicWDbLACMyvc-87y_-gxh-xeqF41lW-6btcf41WFlr2r5q8POSwWRYmhXOkaVi-cdF5Rkgl9Qnx1Quj8dDcMlqF_4byqvTSSp5q6EdA6jk9VDYyWZMpTBIHmzN5U_EvXt1dS9eW2hYqDwIzLZkofw=w374-h705-no?authuser=0" width="350" title="Login">
</p>

<p> Через данное окно пользователь может осуществить регистрацию. Каждое из полей имеет валидацию. В случае успешного добавления будет осуществлен переход к окну авторизации. При возникновении ошибки пользователь будет уведомлен (К примеру если пользователь регистрирует аккаунт с логином, который уже существует, либо с почтой, которая уже существует.<p>
 
 <p> Данные пользователя шифруются при помощи алгоритма BlowFish. Данные в базе данных будут выглядеть следующим образом:
<p align="center">
  <img src="https://lh3.googleusercontent.com/d_ZqM2j26ONIcQq6-Bu7hSTlws-0rY6mA-nrbrU5WY2ZhPaZeYvnmMzT2ni5V6f5Sj4W3fLn9_tMJ1lsbzO_3OHm7DuErnG2udGEcrEYY4-HwBlPNPpnlRYb8itJGMBBAqLIx953fWe-nxjnAAy8Sz0scoPAu-FRPzRsXuGa2l24ynPZMZqeJDOZnUkUOlphufJt-byIg-8NMSGe0e9qQTD1eC7jK2fb1vi5iRU74c8QT2tVtZ6Y9rBozVg_6rtkap6nrvJt6HHnCXFMkbRISbYY03dI9_4TgiqFW1quOPbK5BqRf0m6KDFJ9LBSBz27MuRTxtkZv6Bi9RZt9EioR3INZkx_1Oj4dCEkk6rPC8P49jxz9zGDxZ_o6WVkE2pkuwyyEh5GqIY5MPnxdp4FG9p19zYV7YRxtK4jHMYOrEnRtzkuWoFyeFc_X12SUNCmSSy2TEUykfoV4f4usMEtdOV-uITpX4auvIkbIW2r0EXfikWDuyDf098EKjQjk-SZUyYcLTrnLKw260qNNsMDwmcRKkfMDeKAMjFIHFXvskcSzrd_A_Rnx1kuBy56AKmJMhmOSIUyyTbo6zEreUTV0o5XxQopsT9-lqavccS51mD8u_GdgHBi7tMC-TCBjk3d7lYeNJx-6JtWBzLosWpLKLVovVK09VH6TeAigTBjJXX0campwRy_ZeYux3r5OQ=w544-h89-no?authuser=0" width="350" title="Login">
</p>
