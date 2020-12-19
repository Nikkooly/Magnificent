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
  <img src="https://lh3.googleusercontent.com/RuwAuvb4Ck-lhv7wwwhC0opvFrB_qwOtMIqlCRAV7-ZxqrSlLhPZVWsa8OXbk1gW3sWpz91RzYRj9CpRM-F9MbfTMBQOuz6FahHQTUWdokxdDy0QJAd2NyyTa1DHqOO-Mb69OQpMKm-MII8SbscXb8yeQfkZ2eSIbh-WBmP_vPkq1kEpCv1mfSrDR3ntWvYJJSwEsQ6VG44GwZLTgWsF3UckMYGnKp0rWSrcTfe9oMJyyH9lGTS9nlRLR19XEOdOvx9VlI23o5JNuenRentqsjCD_kpoTEvGWE8iZtJQ-PkgA7fVRpVora6jSSHM7SUJ43cnXhHvT2GDFLL0sqrmbcDXyhgIGu0PKvGbWDLuqHEyzfESp6vO6GQTT1lxj3t2xo6y1znvRrZZL8mpK3APdmEtJRBXohDRuBzIP8TdgQDpeXB9NmIA4m0k2k5PnpBB-vDGHodY46BrK1_4Rieo7ztGb-QXFyu29bvSK0uK_onAcke62gzwxUAKiPN0HcQ76aGZQ5waEOYqLolj-Rmq3MOBNgy74dpgEsMTb7xKFgVdY0xNQq-AofWLKs0PDoamIzcj8AL82h0PFQtRhirfaKTd2G11hOXblJx6_KM3hJQn5Gpt7b7YzyVgXCvtGUKYtpOzpz80AEWTVymV6SLlUqacmUpYNs5K3br-Or_h2EUzfgqRqG0IlWNSBYymUg=w204-h383-no?authuser=0"  width="250" title="Login">
</p>

<p>При нажатии на конкретный фильм открывается окно с подробной информацией о фильме, в этом же окне пользователь может почитать отзывы других пользователей по этому фильму</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/V3TH0o1cHvK7X2HBtJKHBCOgI-eq-DeqrfpfPR-KC14LfG0UllSYqbI3u-oMGY-5VWEuaH_ii7u1rtmRQuoDpY7PQVFRGpmQLcugEtExUfAic5Ricsmo3Cy9pse7lX05cemR1JrM3qRO-MXu2DdYau7f8NArECTBSG_B-iFufg48a72WZaVt0NBKyKncMeLXNZ-HpMDIcqP0do_vLBHfCj2eJl_6jZbG_uWTsKx91h6-W-x-wA5b-thhfaqsaKw8ZBov5kUfyiuYnBsEBpax4z_6Lnfyd0tTt10PsclfuVHS-kIibez3_PnChyirwpnMSnKngtxL1Kpr7cT1Ul96PEh7mPbkV-pnoN24ncgPrHD0apRnIV2gHN0mPgoVEWb6g3_n-CDiArJQ7pO_cGdR7iwDJpuE_1xQT9S_ni2bMN0nw6taG7Z1iqvShyX2lJV4lUkE13Mbk5amDmKtbYBLXV693rdCMUhRaV2JSVR8E9WRgGCq55ZpHubhFfufJmTsC4Hbn4BXdS77B5dHmVt4tKI3nC3dHPmkRJ1nZZ3PRrdxBAIx0LY-zqr-ofC36Vom9RW5iyBlvEP-dEYcMv5UVyN2fAx5khP7diiXD9M_H64xwgiCRtxgYXDsjlmtAKM_aRA2XOWuPjS62WNQZLTwVY74cN5FH0G370b0B2P-eICHNJn9NXdnJJ1PClhqOA=w377-h704-no?authuser=0"  width="250" title="Login">
</p>
<p>После нажатия кнопки Забронировать билет попадает в окно выбора сеанса, где можно выбрать кинотеатр, дату и время сеанса.</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/PSUh99U5CcbBIdpvAIXuKEl8HDtiZN3SzCG1faK5pCHOvfYsvEFJmMnEvBlfRvCSSeq4qjSSDh13PMMf6h1WQJaBu1EZzmFEuXx7R_5OHFEYE9L5QI8U2XV6pNkLTxsIgZGW6WjwaqNTaJAptRr4UnhQjMX6LEHHULdP5Xy2Co2qfm4J2Ff_02AGBA2ctDF85liS5Yrc7PTXwwEc9ITlViJcppVDLYibnDvNsyQhxPCirG0loJWmfuBZvkrCZuaZK7epXD0lqEyMqQvN74nIVq4drfirPYyqscEhlkegrHEOsAQp570kkoyqjO0kVvIlrvKZL5DELL1a_8SqxSNdtjwrY1W4M50yE6M7U9OuSj_Rjh1d7CcGhgWozmOgor-hM6Ewlpt5frgQ-__-T8hYTHj7NojRU-VI2R8dP4k2LCFXg0K8RrTHL_skKks_O-v7O7MqgVzj6i0i8VVlefxi08b-Di-n1yxPP1fC7kmybC4EgO5VpWVDN-ECIY1VUo9IZEqDA9LbIiGVQj3ieoicVb58TP0A1i0HSzoGr_16KzOO_kC0zU-wWkZoOpvHzdfLNBD-bWy_UdkVzy2UhJmf9cWoN15wX9wcfVR3jyw69vQchk32edxEKuxMLghBccT5IikBBnNshE30AoFuxE0ceu_NTuNDGTy1pGcvVgVWntljTyn0f0SwBsJKde24QQ=w378-h707-no?authuser=0"  width="250" title="Login">
</p>

<p>После выбора сеанса пользователь попадет на окно с выбором места. Доступные места отображаются зеленым, выбранные оранжевым, занятые серым. Единовременно можно забронировать не более 7 мест</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/vfsxV2CMKiSMkkqNGGCVWAgATm9sMNSQV6LTXHwKW3_YzdshdCeE7kMc8BQOHTl9RSUTbI1hDqEeskhvxh5TklRDCeh6e2j3g7Z0s8T2iKUf6hAn5yF2L8f3gOFKJrXBLXJ0s3JHjHou3grmobT7q4OHA8WOSZQ217TiGOxcIw5obuS0I5jRH4XJjS3NpzsKR-4vyjGvu450cclcjuqKHx_2_kZoEu49NZyPmlmque1pmkAHtWbRHdUfZB_UzrjCXCoT5i53uq1pFscoTJlmO_4a1a9ffMGvyaJvyk-XgJIl2XjGbxSQQi65XekrGCpK1Q63dDWipr389BnYwHTMq2ovor5spR88JxBQrVFp7SEOA98Ld2HqugjDByRL417eoSrpVwMVU2xNHepN4ZbiW6by2bqc_eOvcsp6sTY1c9NgGL51rTZNWnsp-THCpq-2JC9icQswPvSSYcmYFPPUSwCGIg396Wl86qG3LTjfYYmjUVFX2dmWbemfrfw3CDlSgB61IAs55tE-Wx8HQHB0274sWBhqPmd42SJwcCAI51D20olrKnS8TlLtFwJtu0mHUPQpxtRWgHpZ5G928VJ8y3C2g6rSdDy0hFw4N1sBNWDyMPvfcxwFa319WcRhevQXkAscMLgDBMKB77iHwqe4zKzNElPU8XcHimRftEYkjkSbI4hWYzUwKSUj1YkZFQ=w377-h708-no?authuser=0"  width="250" title="Login">
</p>

<p>После выбора места пользователь попадает в окно потверждения брони, если пользователь зарегистрирован, поле с почтой будет заполнено, если пользователь вошел под ролью Гость, оно будет пустое. После потверждения брони пользователь попадет на главный экран</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/n-MsMe7Ms9uKO5GZ6I-7a5P76aR70HfXNR89XfaRoEjZMo9QftsZ4rpXdb4DbBc0qVUIWVRsjGRS3jnip1-5y3H1xX6GuuPtBjkmFs6vRNTi_TkwDCRopVzXOHW8hXHtU17IOd5y-rusRMd_b4squc4j4rbxY3bBkZJk7EI4lswnxNQtmcUjY_lt0StChuT8sxBy0Q40M1EwP6VBpnSW3kjargeIfyUvTP49L_2obog0hL92_1JYd-MSWEqYDjtml-u3VrwGgTofgCQB4zkC4MEghiy_d6Iih5gYVHciSbO4gr2h_pl2tydNSFvxliHJfzGPGxUxTY1o8BM19IAGUNG895CFF1zZVlBn6Ft0cxmDRQVWbV7h5X6VA2SZYhSrn_0NSzSpmPNuOT7pgHBjNoqbmnFyL9KI3Lk4jQb1JpHVDGNrv1VMWH7ZakgfdWWG8id7GJc5l5w-LYv8CqhRJAtCI4AUeh-5YEBsWzyFi8DBRN9hWsR6ufxJZ6PD9P9g1MUuf2M-0ILLhhVxodk9nY0mFOM39A9mgV41X8X3l2bj7lAZnyDtV_GYFIr8KiPTCfS8ZH9X-5IHWpENy3qYgVa7iFC51TFwkTMyKatvfWiyTinD9b6O2lP_rElbqGlMHPvS8WiyYdZJanGofaM8RcWp8KFJpuyVsAzw9q1QGj3t41FmeRtpDkrOIog8Zg=w370-h697-no?authuser=0"  width="250" title="NoLogin">
</p>

<p>Перейдем к описанию функционала менеджера. После успешной авторизации он попадает в окно менеджера</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/BpM9wp7MnPLybwOoC-r9b6cdtNcNJZ37qZqFkW400QuZaTi2cmTPLw5cO0lq0g01DGDsOF0D_2yLHjgo8vKNiaAeAVgMmzX7GzNC64_j6R47ytKw_RCN-NQecGyYkcbxFPd5D8db-xdJyYadzMSm-LXcWpqJwGFHzGCmlKO_qTA56PryL2kpto4PJhKR8LL4cIfZxZgl8Z_4YT4gnryqq87FBDGUq5yLsm9ttk5D1m3iC8VFn6EiGhD-F5WP1W3tTjYfmLhF9cY9GT3JfeQ5EeBHCuzKaFJ8M3lKuqjHYyW6TH9JguPdL2QUL8_tS17AcgxcjtkfgRMeD5DMEqucWv2g5jAagjpCSDNj-XPuw7VCrmT6a-agJnXz_HaW--gH8ULtvWKdNDDfJuexTduz0Dp4DcJR6C5qp0IzEDSa-KqyX3fnXkruTxfYcTJjNyHjU7PeY4DEmPxpXvOufPQe9F3OUc6Yb3ttjI7dpPdF8j4oOC2vKh-jr2ehyzKhjOKidsfjn1kHDN_h9fcqVclCmOmXXWggiIXl4SnqclQ-t1C4fZukqgZWcFOfY-K6tumFPAwMI-malBlWljQMT5PrtPcGIpyHxylZHb5MY2vP1xR8evQyo9t7lJNLZgTpeY-g0wInDX96oNB-LuiEWRBAdaq2-rFtA1HfAPyQpggI05NOdkvNaXApWC3WmD4Czw=w377-h705-no?authuser=0"  width="250" title="Login">
</p>

<p>Во вкладке Фильм у менеджера есть функционал добавления/удаления/редактирования фильма.</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/d5Imj_vTRNDcbv4mZ_eEpIcB6q7RYswOyNIAM5J7ErfCDE0CJ_wEhvc9q61lHqvnQOkSHDHtJlbYGdnvSLLuuxTLlzMQxw-2QPFfASYG2XsaAOv7bbsmtV4X5q4ZKo-gaYyhTnHZjQ-msRyy3S_v-La284SJdv3TauMWhpzNwOeEsmMXFFhEM36LfbiStLK_TbrPhY2kNUS2oxHcKTgqI4KiaqvNrd8kobC95mBXUC1H0QtHYzWZTxbENhhgaYmucFkKn8pjmtbbL2w14CiqO5Na2G8VIPxss7t-uNkX8r2dGKNG2r512Ev_zU2hYMp9hxCL_Kj3ibjrzl409QYxgsbyjrxkVRTjlhEmBtfNHVV5omnj30PVu5VFDVC0QKQcpvx8qTl88A7ZU7eUanh6jQvNYR5Y3PiVLSfqr1N9OnvxHb0JmycbuCRdvnWgj-taBYBFKFhV30CFYbSOl5fTs1XdDbXY8pbELLl0cPdxLSpcSmJV1q7hIoskKfofkjArZNJC2RhtJAdZx-dNdrDKO95izvrv_io-yccqpvpSdTOb8XBPf5ZjzO1uigdnBNXqiUgSJEGThGWmfh5i-OST1Y3-XBWDm35DknGb3ESjG3qU5iWkI3vcnMwyteEEjuoM9XPObOYFNG1oEKrZp6TlTlirm1h3LrvVfjKA44zPUs7-Q9TUxFjCcyh7oPL1lw=w1129-h706-no?authuser=0"  width="550" title="Login">
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

 


