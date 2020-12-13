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
 
<p>Через него будет осуществляться вход в приложение. Для авторизации требуется ввести логин и пароль. Имеется валидация логина и пароля. Для того чтобы просмотреть введенный пароль имеется ползунок "Показать пароль". Также имеется автоматический вход при нажатии на Checkbox "Не выходить". Для этого используется SharedPreferences, все данные хранятся в зашифрованном виде алгоритмом BlowFish. В случае успешной авторизации, в зависимости от роли, пользователь перейдет к окну, где отображается слайдер с доступными фильмами, менеджер, к окну менеджера. При нажатии на иконку приложения будет осуществлен вход под ролью Гость.</p>
<p>В окне авторизации, а также окне регистрации присутствует ограничение на невозможность создания скриншотов экрана. Если пользователь не зарегистрирован он может перейти к окну регистрации нажав на "У меня нет аккаунта".</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/jcjjABkWJT6xggZUJNpk0i9bLzZfdrSYNYSdxEXeA_J6L1lTXsiJ9hojRugLKwOh-Q4sGK01rUIHPp6f6_ajF1k5yiIH6WoP1X3sS88HVZGYzkKuPcfunmvunFHHizRor4aOdWw_hZcclIEn4PzsCOBewcZemcBXIzzai4jh6njqbdhR0ZCGTbiHpVChc9owPlZ-3vnC9QsOGs7XPyvTXR8S8BfarPe9V13Y1HUNtRg2tnZm67ctoFiwEzL6EPqSXqWI8ThjHqAgMHlz2q6w9dptmyjNfXINrEShSVdj1ciTIqqBXEtImi4o_lmc3Wnv_Ro_f2n18WJsT7u0rfc7uhNndoaLK255tvSZjmy6XhLMU22Zp6LXI5gyD9gPJ5Ux01xaKNeoVzH7FTUUEN9a0E3VycaiTZbfAoksAyh-s9pfQDhuInAUlU6SwJ23HfIoaNkN_TELO9emqo9eM9xvWeKP-ZbEgfKOcauZp4RhI7pv4oa9eJcara8GW_YNe8bB0Bx49u9WCiJrAlE36b3LspUWXLiC3L1MO_bhqvREvicWDbLACMyvc-87y_-gxh-xeqF41lW-6btcf41WFlr2r5q8POSwWRYmhXOkaVi-cdF5Rkgl9Qnx1Quj8dDcMlqF_4byqvTSSp5q6EdA6jk9VDYyWZMpTBIHmzN5U_EvXt1dS9eW2hYqDwIzLZkofw=w374-h705-no?authuser=0" width="350" title="Login">
</p>

<p> Через данное окно пользователь может осуществить регистрацию. Каждое из полей имеет валидацию. В случае успешного добавления будет осуществлен переход к окну авторизации. При возникновении ошибки пользователь будет уведомлен (К примеру если пользователь регистрирует аккаунт с логином, который уже существует, либо с почтой, которая уже существует.<p>
 
<p>Данные пользователя шифруются при помощи алгоритма BlowFish. Данные в базе данных будут выглядеть следующим образом:
<p align="center">
  <img src="https://lh3.googleusercontent.com/d_ZqM2j26ONIcQq6-Bu7hSTlws-0rY6mA-nrbrU5WY2ZhPaZeYvnmMzT2ni5V6f5Sj4W3fLn9_tMJ1lsbzO_3OHm7DuErnG2udGEcrEYY4-HwBlPNPpnlRYb8itJGMBBAqLIx953fWe-nxjnAAy8Sz0scoPAu-FRPzRsXuGa2l24ynPZMZqeJDOZnUkUOlphufJt-byIg-8NMSGe0e9qQTD1eC7jK2fb1vi5iRU74c8QT2tVtZ6Y9rBozVg_6rtkap6nrvJt6HHnCXFMkbRISbYY03dI9_4TgiqFW1quOPbK5BqRf0m6KDFJ9LBSBz27MuRTxtkZv6Bi9RZt9EioR3INZkx_1Oj4dCEkk6rPC8P49jxz9zGDxZ_o6WVkE2pkuwyyEh5GqIY5MPnxdp4FG9p19zYV7YRxtK4jHMYOrEnRtzkuWoFyeFc_X12SUNCmSSy2TEUykfoV4f4usMEtdOV-uITpX4auvIkbIW2r0EXfikWDuyDf098EKjQjk-SZUyYcLTrnLKw260qNNsMDwmcRKkfMDeKAMjFIHFXvskcSzrd_A_Rnx1kuBy56AKmJMhmOSIUyyTbo6zEreUTV0o5XxQopsT9-lqavccS51mD8u_GdgHBi7tMC-TCBjk3d7lYeNJx-6JtWBzLosWpLKLVovVK09VH6TeAigTBjJXX0campwRy_ZeYux3r5OQ=w544-h89-no?authuser=0" width="350" title="Login">
</p>

<p> Приложение может осуществлять работу только при включенном интернет-соеденении, в случае отсутствия интернета будет отображаться окно, которое будет закрыто автоматически при появлении интернета. Для реализации этой функции использовался BroadcastReciever. </p>
 
<p align="center">
  <img src="https://lh3.googleusercontent.com/FRkxgE91YPhXIrhtCxjHST6A01JudDNIDZGN-v13otQz1rj5a4YwMZcPt1Re1r8gFDaZA7NFzmDjpQSL_b2FFTmE_hPRjSvjqOjvy6YJamDaKrRTDu7kxsGxcnOrZq2e1PveI-GRqmZIN8E6tt9i_JHZZ_D_xu-hpATbHTilb-sSu9UTz65t1VHyAVCYvV-zEyy31uJBW62_iyp4Yp-yFqnbdSIBd9kkjVrdx50ECpk5RRxm3je2MICLqb1_-4w1lDeVpH_6ldWGlcKNnK7dd9q8BdqdlnVP2Fp0tt0Z8D3ShOoyRYqvBgdvvgKjlsLtaYdV0InA4PJtnfvlM46JooxqYnPVOpP6r7Xp0EmcFE1ZA9vW3zHZMenFLmnkCy9vEyQAyRTjGGw2YU9Vu0iTpUa9TueEeqGrrvlbTBtatLrtXtQ953qteGjlEbKz6VobVQaDOvR4qOTIB8RnkXk74EVdTwbQMzSSuCp3Ksg-wtgivzPh_fedr_g05wF9Brt_AjntqufcLj4gfcZiMsn-ITng3sH9xmtVbcfjzmz90FOaiPe825iU7_4b_Zj0WcUvjplS9k2Ii4_XAs6AZiXAS70fYUFblxHRvYLDaXNPCrslQnIO2PADW2uDbFjWLr6llAMANC8niKhCJtQR9kQr8CC7JJwZRX-Cijk9wzQV_L54stfWdGdMC-gYfzcEbQ=w454-h908-no?authuser=0"  width="350" title="Login">
</p>

<p>После успешной авторизации пользователь попадает на экран где он может просмотреть фильмы доступные в кинотеатре. При помощи PageViewer он может их перелистывать.</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/s6IgBuCoSkEPiaRJgN2KXb66MfsAeUmFGe47r2NWV-mtwhWcuxJXzjNhDVzdVI_HgHjU7vYs_SS_r04mJbxzy_SozM6EX1zd3lX3pQ6bicU7ZYbFR3NDNTkny1SD9jPdMaTwR2TtxZ5hjU8XaxhyS-nq_1IMwKRkIxjIrCKQIUvNC6do2M7h93ZXRlLAAPlkybzGfP6fS4ZKw2bOdcX6Fq9rPKgrvQ3l5GHrxEcGUsgDUahj7j0iOvfkfh9El7YCGPgOPUIplX6h7ZowiI51Dt9yGdL5Nweoai9iztKZQ29IgnprwsmBO7OqNN22ZQ7L2J_Ms1ZbNco0y5nky-Ocx2TzmRBGb0Tpx33oby1mvJ75syIcVWU2TqW2QQORpuZdzeEZidjDTllAvrarTgsxrAlbVBFYq4c8-Lz2npUPY3BzE_pczKp9FS9JZCwJLDNY-OWQ6xsF2Pi7hKK7dJKsbmdbASTt5-Mmar-xl0_qWU6rzi_taZ3_FXe4VYh8tCjiiGtby9XL58EMK6at623eIlgnCHrH2cyE2jtp1zyJyCPDFxqLsSTYHBxco_97bd6ldzUB11TLCFg6pvWctX1-CDKgB30F4A3gFYAChgIfmAdy0LRGy0_NdVwicT0PXUzUq28G3ChMWWOTdBbw61ta6XAZz9sD83rulpw9TCTMYWh1SH2YoXsLae66NFLlYQ=w377-h703-no?authuser=0"  width="350" title="Login">
</p>

<p>Во вкладке кинотеатры перечисляются все доступные кинотеатры сети.</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/sTWVGxNRY5_iVQyaduLUPeCbYoM3xGPdOX33nyGP3RmOyrTEXL6eK3sRak02qELBZ7-om4mUAOqrYgVC2xrgjN6WHbLQDKnWdeYuyVVE6_BhtBsHFzU84GYXHwBz3AbYGJ4XWUfsd4b_fEAPc3hy3cMGDMpz_pZCQ87pAPHssI02zCbIF_0637Ro3mXWrt-jbt7vX3jqKKNXLhJZ55abBMuCvQ1jHqvZMeplY3qcqpv8proYXnh_nd23sUYMcXRdFJqNep5KGDVGJcnm3EGq3tNM_I6nzgkOozKqeilMwDDPeujl6JPSS68pCHbeZNrT9d_mtwgpmTtfVZYSZZceWtVgGE4NsIHNjpUgY3W1_LyxJgN9XRVGMcHFvAs0lF3BsTU_mN9ECxd55vW7VMjfZ0istrwOiR1_wjO1ZkMd0V8JzjglNOaMx1npBWgh7KmjYHXB36J2JwK3xYrlo8kd77FXgPzyHAMfdLkPDdHjhP1oCxTp_BQ4xthVXVtqU1k2PKVfGIqRlIyA9t05tVxRyw4dqlYgvnggWqRhhOdxjuozRF0aGLnQzSNox8S03ZCBflAFwP5K8nKI-hnGbeZx99s3MaXYxguqMBjdgs61ETjvaes31JI6UQrXqSYC34raYrp3aQktYSwweHmW9gBFdbRAIzRhFPQ0V_oiceIgbDk7RDG5tDvW3puDNB5tOg=w375-h704-no?authuser=0"  width="350" title="Login">
</p>

<p>Во вкладке билеты пользователь может видеть свои забронированные билеты (левый скриншот), в случае если пользователь не бронировал ни одного билета, либо зашел без авторизации под ролью Гость, будет отображаться окно (правый скриншот). После того, как сеанс закончится у пользователя будет возможность оставить отзыв к фильму.</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/Njf_X_lBpYdF5wEgv5z_wohfk-3HxWAoEA4wpF8Qxpj1k6paYlcPp821L0lBB3YbJ2OfQ4XM3mTzWOeh95HwnV9MWABgWpAvJbISf-GA6FcToG_K5ZAnfUvjIU1CL9f-Owe_NP7d_xp-xG1QXLd90zldtRVZj6KZpTHxFFZhmRoGDis9PhQBcVz0KCMpsC9aCkAZvrIEkz-zy3uHoUo23YXB4CjgBba3dmsntab7ziWb-CW_piqJ6AiDFZE6Kb790EJnarUm50k52aJOycxeiVoPl_4_hqFllPVXxA5JP9gkxbCNnyLTMUXFbdmrAo24EHaWjPzn3n-6pC8vcfpxLM-Ubgu0wkm_Ywgf23lDwlkJ8XvKODRa6Nug3zOWHHE00SHFgvi0Y_nbly2oLR8dZDILntuU3tSgq_3XSKh_I1QlrEloAFFe1Qd83MR6sRia6Bn-StMFS6e7WYKztQUb8LxwzqoDRoN13e7_Ikx5UxXxzTNOFV80RiFUAHZUGrG_y_BQRJC5EFsXf70tZvW8Mp0dWO5dA8AejhkFA57hxzzlwzpUN5fFwszCMlAm_cQapbA5yN8IRQ3IP7cHK8J5rg9LgULpLxaEt0Zg4R9hbymEOKQWNGsO585Vgh9LVbDza62o2nFqjzpU034fzTskoX-NfCepVnr-7ZkbyFnYHy_U8hYe6JUkGPwCJi_r_g=w752-h701-no?authuser=0"  width="350" title="Login">
</p>

<p>Во вкладке Еще отображается контактная информация, а также имеется кнопка выхода из приложения (у авторизированного пользователя дополнительно имеется кнопка выхода из аккаунта).</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/aulLTp4OTaGPpf-7r6AYmSesPvI-XixrZ6k6opWpr9Zh28KWxCsX-XYk17ZGz3fHIoFsagHWuzJmXFxqK1647vVYsrxzVIQI-qUzpT1jAjOtxH4BKElZbe28_oaZLV7GvQmBmxKka3wI2aSjzYQJF0XRrwpAFjYGfZwanqwIl0mI_tTvF8YP3IyLXHDcYGeCNxZDHhvA2LOyCylj1uy7PSAY2zubx33GE_yFmacIrxvQrMEQT3JGZDIkTNUZzdbrc_bB-Z1o3hIde9X0Sh1jZwnAXqs8KgTsS4gQWtgv_WXVFpfyinnU20aoY7nRvGfAnHytBO06doewsc0ldILex_O2YejsVm_fujoAIkMU1yRD6lzGafv4VZVErXCdqaoSuDhQ_qF0pLx6TRZyWY9jISHlKNogKoyHRV40MA42QzelfqqzIu4-5BTGPlLMjA36MrpDRlXWcPrdY7fgQnCMWRgP55MVdhbatQxQSM7IcOap3poiQ-cOKMrDSfoHkkP6RBvgpavJ0PbAk3noSelG20IVbAdiYwRsO0XtHM4tXJqGoKT2-HJYZeXnjUTfFcZeMzTvaNDxwy9KJaCRHCGWl9bBegFpFwr59WBuQNpFLk7TgY5zaNY2HVNtsEHgBql8Wqjw4w3XVhLJsE2Fe-bAfxCG65uAkT9SMc4ssSHQP4g1Vw0LA16lKcBVD-Piew=w375-h704-no?authuser=0"  width="350" title="Login">
</p>

<p>Во вкладке Фильмы отображаются фильмы, на которые есть, либо будет добавлен сеанс. Пользователь может пролистывать фильмы.</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/RuwAuvb4Ck-lhv7wwwhC0opvFrB_qwOtMIqlCRAV7-ZxqrSlLhPZVWsa8OXbk1gW3sWpz91RzYRj9CpRM-F9MbfTMBQOuz6FahHQTUWdokxdDy0QJAd2NyyTa1DHqOO-Mb69OQpMKm-MII8SbscXb8yeQfkZ2eSIbh-WBmP_vPkq1kEpCv1mfSrDR3ntWvYJJSwEsQ6VG44GwZLTgWsF3UckMYGnKp0rWSrcTfe9oMJyyH9lGTS9nlRLR19XEOdOvx9VlI23o5JNuenRentqsjCD_kpoTEvGWE8iZtJQ-PkgA7fVRpVora6jSSHM7SUJ43cnXhHvT2GDFLL0sqrmbcDXyhgIGu0PKvGbWDLuqHEyzfESp6vO6GQTT1lxj3t2xo6y1znvRrZZL8mpK3APdmEtJRBXohDRuBzIP8TdgQDpeXB9NmIA4m0k2k5PnpBB-vDGHodY46BrK1_4Rieo7ztGb-QXFyu29bvSK0uK_onAcke62gzwxUAKiPN0HcQ76aGZQ5waEOYqLolj-Rmq3MOBNgy74dpgEsMTb7xKFgVdY0xNQq-AofWLKs0PDoamIzcj8AL82h0PFQtRhirfaKTd2G11hOXblJx6_KM3hJQn5Gpt7b7YzyVgXCvtGUKYtpOzpz80AEWTVymV6SLlUqacmUpYNs5K3br-Or_h2EUzfgqRqG0IlWNSBYymUg=w204-h383-no?authuser=0"  width="350" title="Login">
</p>

<p>При нажатии на конкретный фильм открывается окно с подробной информацией о фильме, в этом же окне пользователь может почитать отзывы других пользователей по этому фильму</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/V3TH0o1cHvK7X2HBtJKHBCOgI-eq-DeqrfpfPR-KC14LfG0UllSYqbI3u-oMGY-5VWEuaH_ii7u1rtmRQuoDpY7PQVFRGpmQLcugEtExUfAic5Ricsmo3Cy9pse7lX05cemR1JrM3qRO-MXu2DdYau7f8NArECTBSG_B-iFufg48a72WZaVt0NBKyKncMeLXNZ-HpMDIcqP0do_vLBHfCj2eJl_6jZbG_uWTsKx91h6-W-x-wA5b-thhfaqsaKw8ZBov5kUfyiuYnBsEBpax4z_6Lnfyd0tTt10PsclfuVHS-kIibez3_PnChyirwpnMSnKngtxL1Kpr7cT1Ul96PEh7mPbkV-pnoN24ncgPrHD0apRnIV2gHN0mPgoVEWb6g3_n-CDiArJQ7pO_cGdR7iwDJpuE_1xQT9S_ni2bMN0nw6taG7Z1iqvShyX2lJV4lUkE13Mbk5amDmKtbYBLXV693rdCMUhRaV2JSVR8E9WRgGCq55ZpHubhFfufJmTsC4Hbn4BXdS77B5dHmVt4tKI3nC3dHPmkRJ1nZZ3PRrdxBAIx0LY-zqr-ofC36Vom9RW5iyBlvEP-dEYcMv5UVyN2fAx5khP7diiXD9M_H64xwgiCRtxgYXDsjlmtAKM_aRA2XOWuPjS62WNQZLTwVY74cN5FH0G370b0B2P-eICHNJn9NXdnJJ1PClhqOA=w377-h704-no?authuser=0"  width="350" title="Login">
</p>
<p>После нажатия кнопки Забронировать билет попадает в окно выбора сеанса, где можно выбрать кинотеатр, дату и время сеанса.</p>

<p align="center">
  <img src="https://lh3.googleusercontent.com/PSUh99U5CcbBIdpvAIXuKEl8HDtiZN3SzCG1faK5pCHOvfYsvEFJmMnEvBlfRvCSSeq4qjSSDh13PMMf6h1WQJaBu1EZzmFEuXx7R_5OHFEYE9L5QI8U2XV6pNkLTxsIgZGW6WjwaqNTaJAptRr4UnhQjMX6LEHHULdP5Xy2Co2qfm4J2Ff_02AGBA2ctDF85liS5Yrc7PTXwwEc9ITlViJcppVDLYibnDvNsyQhxPCirG0loJWmfuBZvkrCZuaZK7epXD0lqEyMqQvN74nIVq4drfirPYyqscEhlkegrHEOsAQp570kkoyqjO0kVvIlrvKZL5DELL1a_8SqxSNdtjwrY1W4M50yE6M7U9OuSj_Rjh1d7CcGhgWozmOgor-hM6Ewlpt5frgQ-__-T8hYTHj7NojRU-VI2R8dP4k2LCFXg0K8RrTHL_skKks_O-v7O7MqgVzj6i0i8VVlefxi08b-Di-n1yxPP1fC7kmybC4EgO5VpWVDN-ECIY1VUo9IZEqDA9LbIiGVQj3ieoicVb58TP0A1i0HSzoGr_16KzOO_kC0zU-wWkZoOpvHzdfLNBD-bWy_UdkVzy2UhJmf9cWoN15wX9wcfVR3jyw69vQchk32edxEKuxMLghBccT5IikBBnNshE30AoFuxE0ceu_NTuNDGTy1pGcvVgVWntljTyn0f0SwBsJKde24QQ=w378-h707-no?authuser=0"  width="350" title="Login">
</p>
