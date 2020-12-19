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
  <img src="https://lh3.googleusercontent.com/pw/ACtC-3fgm3XnoyuIvc7syedWTHNMld9eOrIqWk02lDw7TxshdrbJEhFx7Vd95VoLphhKGNJ1kJSIU3rSB7Yn-4oa0Kws6ikN48AGB3vKLXZprb6pGWA7zaCytH9TkUmMkQ3l8sLCIoX3xhLmu0PcJ2NL8eyO=w373-h705-no?authuser=0" width="250" title="Login">
</p>
 
<p>Через него будет осуществляться вход в приложение. Для авторизации требуется ввести логин и пароль. Имеется валидация логина и пароля. Для того чтобы просмотреть введенный пароль имеется ползунок "Показать пароль". Также имеется автоматический вход при нажатии на Checkbox "Не выходить". Для этого используется SharedPreferences, все данные хранятся в зашифрованном виде алгоритмом BlowFish. В случае успешной авторизации, в зависимости от роли, пользователь перейдет к окну, где отображается слайдер с доступными фильмами, менеджер, к окну менеджера. При нажатии на иконку приложения будет осуществлен вход под ролью Гость.</p>
<p>В окне авторизации, а также окне регистрации присутствует ограничение на невозможность создания скриншотов экрана. Если пользователь не зарегистрирован он может перейти к окну регистрации нажав на "У меня нет аккаунта".</p>

<p align="center">
  <img src="https://downloader.disk.yandex.ru/preview/2a2ecdf20cfa6dda2b39d841cd6455cf2b28fe821f54d3db05038022f31a2196/5fd89d40/F1hgc3ny-t5NLNmF2x4je7itT7mt_pp_H5QVNBspqKJQQ9K-Mxw7pepg4wD0PHE67j6b4wiadK_dmVrr8Kfj3w%3D%3D?uid=0&filename=Screenshot_2.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&owner_uid=0&tknv=v2&size=2048x2048" width="250" title="Login">
</p>

<p> Через данное окно пользователь может осуществить регистрацию. Каждое из полей имеет валидацию. В случае успешного добавления будет осуществлен переход к окну авторизации. При возникновении ошибки пользователь будет уведомлен (К примеру если пользователь регистрирует аккаунт с логином, который уже существует, либо с почтой, которая уже существует.<p>
 
<p>Данные пользователя шифруются при помощи алгоритма BlowFish. Данные в базе данных будут выглядеть следующим образом:
  
<p align="center">
  <img src="https://imageup.ru/img37/3687852/screenshot_3.png" width="450" title="Login">
</p>


<p> Приложение может осуществлять работу только при включенном интернет-соеденении, в случае отсутствия интернета будет отображаться окно, которое будет закрыто автоматически при появлении интернета. Для реализации этой функции использовался BroadcastReciever. </p>
 
<p align="center">
  <img src="https://imageup.ru/img32/3687850/screenshot_4.png" width="250 title="Login">
</p>

<p>После успешной авторизации пользователь попадает на экран где он может просмотреть фильмы доступные в кинотеатре. При помощи PageViewer он может их перелистывать.</p>

<p align="center">
  <img src="https://imageup.ru/img149/3687854/screenshot_5.jpg"  width="250" title="Login">
</p>

<p>Во вкладке кинотеатры перечисляются все доступные кинотеатры сети.</p>

<p align="center">
  <img src="https://imageup.ru/img214/3687855/screenshot_6.jpg"  width="250" title="Login">
</p>

<p>Во вкладке билеты пользователь может видеть свои забронированные билеты (левый скриншот), в случае если пользователь не бронировал ни одного билета, либо зашел без авторизации под ролью Гость, будет отображаться окно (правый скриншот). После того, как сеанс закончится у пользователя будет возможность оставить отзыв к фильму.</p>

<p align="center">
  <img src="https://imageup.ru/img109/3687857/screenshot_7.jpg"  width="350" title="Ndndnn">
</p>

<p>Во вкладке Еще отображается контактная информация, а также имеется кнопка выхода из приложения (у авторизированного пользователя дополнительно имеется кнопка выхода из аккаунта).</p>

<p align="center">
  <img src="https://imageup.ru/img155/3687859/screenshot_8.jpg"  width="250" title="Login">
</p>

<p>Во вкладке Фильмы отображаются фильмы, на которые есть, либо будет добавлен сеанс. Пользователь может пролистывать фильмы.</p>

<p align="center">
  <img src="https://imageup.ru/img70/3687866/screenshot_10.jpg"  width="250" title="Login">
</p>

<p>При нажатии на конкретный фильм открывается окно с подробной информацией о фильме, в этом же окне пользователь может почитать отзывы других пользователей по этому фильму</p>

<p align="center">
  <img src="https://imageup.ru/img91/3687867/screenshot_11.jpg"  width="250" title="Login">
</p>
<p>После нажатия кнопки Забронировать билет попадает в окно выбора сеанса, где можно выбрать кинотеатр, дату и время сеанса.</p>

<p align="center">
  <img src="https://imageup.ru/img81/3687868/screenshot_12.jpg"  width="250" title="Login">
</p>

<p>После выбора сеанса пользователь попадет на окно с выбором места. Доступные места отображаются зеленым, выбранные оранжевым, занятые серым. Единовременно можно забронировать не более 7 мест</p>

<p align="center">
  <img src="https://imageup.ru/img161/3687869/screenshot_13.png"  width="250" title="Login">
</p>

<p>После выбора места пользователь попадает в окно потверждения брони, если пользователь зарегистрирован, поле с почтой будет заполнено, если пользователь вошел под ролью Гость, оно будет пустое. После потверждения брони пользователь попадет на главный экран</p>

<p align="center">
  <img src="https://imageup.ru/img129/3687871/screenshot_9.jpg"  width="250" title="NoLogin">
</p>

<p>Перейдем к описанию функционала менеджера. После успешной авторизации он попадает в окно менеджера</p>

<p align="center">
  <img src="https://imageup.ru/img26/3687870/screenshot_15.png"  width="250" title="Login">
</p>

<p>Во вкладке Фильм у менеджера есть функционал добавления/удаления/редактирования фильма.</p>

<p align="center">
  <img src="https://imageup.ru/img290/3687872/screenshot_16.png"  width="550" title="Login">
</p>


<p>Во вкладке Кинотеатр у менеджера есть функционал добавления/удаления/редактирования кинотеатра, а также добавление/удаление залов.</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/ytV32Dahg63cCtg1_60RdNpvlgN1gs3cauwvDfDmTB0F2ISj4drqWWBYgGM2ROLucewREmc8k9RYwqIFGDHcS1K0276prXHGVsuq3x_pnfutTRnEkBrQeCIDYmwKo-fscltSZxNHZHxzhBYUaDeBShBtFQ5AttERlkT2gd2_mE4earXN_7rPCcBuLZcnebWZ9rAdcFmDrWQ7zdoWvMwEc-doCAWDEcSDiD2MgmH67oe3OpMOBfZxYpoVsSB7p8BYXF5K5hEvQ1BKvQahCq9z_E4Jwv3Dl3PTDIz90hLyYNfbmTSwewme9EnC8J5eMpUnsDdAA3sdMUJ34Kg56Erc9GcFB-fPVXgWmbKHt4Wvj8vhUxQHPJ6c-Orq7Gdu9TIaRMcJndNH3j5kFRysVjxqdSQ_e0Z4YAK9My-8wq4KLmkTIZzDyFhoPYQG6pFFJcHWQrJKaKGAkmmUrVaCXKamLn-RR9FIPp5368UziEfdWklrJyK18ELlfpBQj1Miq1AyhAd73PZB6b8hYl0DfqzeuCgSpwjmp-tk4YbC59bd60K6H0Ke2J14gMOZmR82J5axvjOr7J9bxGnDzysELF3qTV0_vdbpMBWw6wNrwHEx8DKm985UX6Mq9-jzbtqtwyKGZY5zudIOnnmYApjoFka_6M4lTMvC0cK_fPu-T79w_73iSesUJQeHMKDETW_8PA=w1134-h707-no?authuser=0"  width="550" title="Login">
</p>
<p align="center">
  <img src="https://lh3.googleusercontent.com/oAIgjPm5xR7ThzMlj7x60XqiPWJXykqx4nBWUcElicD24_BMVfm6cpS2L8zkWx5gAsqpMuek7pjeJmIKkyBXahnizjRap6WQbPZkjn3rX7RIK1OPnkrcJCquzh9ImKCUeKjf9er2EZxz-rfeYOf7K8tCdRqMAR1P_r4NpyRKWv3y28v7cYas2i6ARRL4WA1yLxBbpwNFwyhXBb_hYuCUbH_9O8JOQ6Be5kWUJNu-AEtQkhuqwbmyLH5a-u52iqNptymznJLIaigqZB8Q4bhAVhYErQ4He46mqYQYPrHWcul0AnzLXbN7cQs-znC6LZFzFi-sZm2Ko5kT-XHWv51DCJb1sbit10GuHHq4izrk8wwgL27L-i6-HRS0bW1N4__NCEfY8Lz8H3b7xKMoi2rJdTJZHHlyeEjnge_vXF0XfBRcLnbQFXyFqQvAGkjIzEeI238l5w9CaT37g0kIn20x-srxfifbihHAqS4SxP0XyER0hvIOUR4Vgmn6EdH7hjVIEEGz8TJ1VosvPP0rk4_nM5dDYtv1mw_0JzKjJ1H6__aklWmK5AH0Zb4AGhfPFj5KjXWulHzE6w_kjzxhOGvoTQyP7jpqjwcnN3jFBK5-ld3IcqaFn1JpyBl5hv5nBzzsQQElxuLnDGkOoLtKuiwdxyF9vGauoDd3IB2_68Y1N4IRDa3DzH6bFXVKj9dhLw=w753-h705-no?authuser=0"  width="350" title="Login">
</p>

<p>Во вкладке Сеанс у менеджера есть функционал добавления сеанса. Он выбирает кинотеатр, зал и время сеанса. Добавить сеанс можно только на дату, которая идет после текущей.</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/rpRYdzgTVKtjkHCUESTTG14JQXDzVWBb2EOT3_o2hORvomkS-g00VtHSX42q1O3fAYRrh64Fk-OGbWEOh2vjmY1_8XqSy2maOMtdMImTJrogWVxlqAKBxHKvk1DAmv4z6Yv9GvYZmceQTti0ZZLa0Jj621SC3rxoZKPNQMyccmkLja3lu65L3J0NymBQ8bOfGZYEL6jCGRlL_k_TdnKfj46acW60ej21pw7BcYGZJiZJPKwqtcnNp0mq7_AmgsFdGihBwlKSDL9Y1YWYVWCnMKKPcf95qo58QZVb9Foiu2psrqy3jJitrBzdNTzOB8mGlqGU0kn8Ioo_meOyLgKCDk2k-gBeBXJakdY1Hh5RgQGRdx5Et6ehnHFz42kcfm59T0Tda0qGg5l06SedqPs3_FM1OfPjWvuCL4eKnBQAwZKzeBjEuvjndJDTW53ak2NjO0npAe1hbyPw6_vzXRYm_zNURzw4wCpDGRKR2QAHPdPYN9lfmN75U1E8BK95ReOBpX5wI28rv7NwTIpmfii2RyReHwnfNI5yQBzs7D4qFZuwhplOr2wYF8kgJN1tQ7UwPncaf3aaaz5Z-Khu2BzEJpu8o5fpasHvfNhsRnE7cmq19Ty60S3P4T_RBpzXkM5YOQq-I4fuLpD22veui83UZMbC_wPrlCGYsWH8kPBc1OnY6Av-M__gD4nyCRhEZw=w374-h703-no?authuser=0"  width="250" title="Login">
</p>

<p>Далее выбираем время и стоимость сеанса.</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/XjwU81d9xZRZ2xoz1r4Dk5OWycwaQLIKoOrZwk6oiLKQuhw2TUxPKJS8XBGodJkPepogOqVLSnKbUssTTAPnGEzUP4Yr4uoGv3ceFJBH_hx5iMsxClsmgsllnn3zM8Cg-jCrzlagcZjSSbZXZqN1RgdTKfpG-uczJFCrsjVLq9gl5JNnBy8AIcs2PO8xBxlpRDwEk-lNddnPl2VKuHnm_6X9udVvO6RSnqUWOPZ6KEWFqwfL4lvEK9pC_sNxT6TludmMWdmA4RwGV-QBaL2V_kQ06twoZiX3Bhjpd2akEQw03cgNifLljLlRCcmutVclNLtvCQmHxWzz86PSLt208frTZ4N09QjXm7RMn0TPFdM40U_Rod-tMtOMqx2S2hX2sBICjXc8q0BF441tUcQPKfBlYJURgDzvq-_wJnYRtq6oAMxo7OzFa2uBsMvm65QXcoRYDD6VCsg_KVt_aeJoux4egvmlav7FkiVEBAqmSWShNLNF0REqlPN4C8KYDUVcYbbk_IcKnW30nI8IvzaHdi4n5CjkkCdbTOK0nYre-ChPMMWVsoNPVALrqV-IjUGbeQ2dJ2bZT0M_Uo73Rlh-Iilagb2YEjV_xftYmZ5ahvEsfW3Qzcy0LAt-rhKNXbdsTBT_hdYrHp457YH2VTp2BCE73SpajcO1zr7Ex53UUX06XVakKTuuAonDVBKJeg=w378-h703-no?authuser=0"  width="250" title="Login">
</p>


Выполнение общих требований:
*	Минимальное количество экранов 8 – реализовано
*	Использование хранилища (защитив данные) - Использование удаленного хранилища на базе SQL Server(логин, пароль), шифрование данных пользователя алгоритмом Blowfish
*	Защитить приложение авторизацией - реализовано (user входит в приложение под login и password)
*	Реализовать зашиту приложения – в приложении на экране регистрации и авторизации нельзя делать скриншот, также менеджер при сворачивании приложении, должен осуществить повторную авторизацию.  
*	Использовать обфускацию проекта - ДА (c помощью proguard)

 


