<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Title</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container-fluid mainPage">
    <div class="container page-padding">
        <h3>Реєстрація на сайті</h3>
        <p>Для виконання реєстрації необхідно натиснути кнопку Sign In. Після чого відкривається сторінка з формою для
            реєстрації. Необхідно ввести всі поля та натиснути кнопку Register. Якщо якесь поле залишилось не введеним
            або
            не вірним за форматом, або якщо введена електрона пошта вже присутня в системі, то відображається відповідне
            попередження. Після вдалої реєстрації користувач повертається на головну сторінку. Для відміни реєстрації
            необхідно натиснути кнопку Cancel.</p>
        <h3>Аутентифікація на сайті</h3>
        <p>Для входу на сайт користувач має натиснути кнопку Log In на панелі з меню. Після цього відкривається вікно з
            формою для введення даних користувача. Для підтвердження наданих необхідно натиснути кнопку Log In. Якщо
            одне з
            полів не заповнено, то відображається відповідне повідомлення. Якщо дані користувача не співпадають з
            існуючими,
            то відображається повідомлення про невірно введені електрону адресу або пароль, а також пропонується
            зареєструватися на сайті. Після вдалої аутентифікації користувач повертається на головну сторінку сайту.</p>
        <p>Після аутентифікації користувач має можливість перейти до приватного кабінету, замов або закінчити сесію
            роботи з
            сайтом.</p>
        <h3>Приватний кабінет</h3>
        <p>Для входу у приватний кабінет користувач має натиснути на іконку користувача у правому куті меню та обрати
            приватний кабінет. Після цього відкривається сторінка з приватними даними користувача, на якій
            відображається
            вся інформація введена при реєстрації, а також баланс користувача на сайті. З даної сторінки користувач має
            можливість перейти до редагування персональної інформації та поповнення рахунку.</p>
        <h3>Редагування персональної інформації</h3>
        <p>Для редагування необхідно натиснути кнопку Edit у приватному кабінеті. Після цього відкривається сторінка для
            редагування всіх даних користувача. Для збереження необхідно натиснути кнопку Save, після чого користувач
            повертається у приватний кабінет. Якщо якесь поле залишилось не введеним або не вірним за форматом, або якщо
            нова електрона пошта вже присутня в системі, то відображається відповідне попередження, та збереження не
            здійснюється. Для завершення редагування без змін необхідно натиснути кнопку Cancel.</p>
        <h3>Поповнення балансу</h3>
        <p>Для поповнення балансу необхідно натиснути кнопку Top Up. Після цього відкривається вікно для поповнення
            балансу.
            По завершенні користувач повертається до приватного кабінету.</p>
        <h3>Замови</h3>
        <p>Для переглядання замов користувач має натиснути на іконку користувача у правому куті меню та обрати замови.
            Після
            цього відкривається вікно з замовами користувача. Для детальнішої інформації по замові необхідно натиснути
            на
            відповідну замову. Далі відкривається вікно, у якому надана інформація по замові, а також можливість
            редагування, відміни та оплати замови.</p>
        <h3>Редагування замови</h3>
        <p>Для редагування обраної замови необхідно натиснути кнопку Edit на сторінці з даною замовою. Після цього
            відкривається вікно для редагування замови. Користувач має можливість змінити дати початку та кінця замови.
            Для
            підтвердження зміни замови необхідно натиснути кнопку Change. Якщо обрані дати не доступні для замовлення,
            то
            відображається відповідне попередження та зміна не відбувається. Якщо зміна пройшла вдало, то користувач
            повертається до сторінки з замовленням. Для завершення редагування без змін необхідно натиснути кнопку
            Cancel.
            При зміні оплаченої замови, якщо ціна старої перевищувала нову, то кошти повертаються на баланс користувача.
            Якщо ціна старої менше, то зміна розглядається як нова замова та при не оплаті стара замова
            зберігається.</p>
        <h3>Оплата замови</h3>
        <p>Для виконання оплати замови необхідно натиснути кнопку Pay у вікні з даною замовою, при цьому відбувається
            списання коштів з балансу користувача. Якщо на балансі недостатньо коштів, то відображається відповідне
            повідомлення. При вдалій оплаті користувач повертається до вікна з замовою. Статус замови змінюється на
            оплачений.</p>
        <h3>Пошук та бронювання</h3>
        <p>Для виконання пошуку транспортного засобу користувач має заповнити форму пошуку на головній сторінці та
            натиснути
            кнопку Search. Якщо одне з полів форми не заповнене, то відображається відповідне попередження. Після
            підтвердження критеріїв пошуку відкривається сторінка з доступними машинами. На цій сторінці користувач має
            можливість забронювати обрану машину або змінити критерії пошуку та виконати новий. Для бронювання машини
            необхідно обрати машини з переліку та натиснути кнопку Reserve. Після чого відкривається сторінка з
            замовленням.</p>
        <p>На панелі меню користувач може обрати та перейти до головної сторінки, сторінки з термінами та умовами
            бронювання
            та сторінки з контактами. На сторінці з контактами користувач знайде всі доступні контакти для зв'язку з
            компанією та матиме можливість написати менеджеру.</p>
        <h3>Завершення сесії</h3>
        <p>Для завершення сесію необхідно натиснути на іконку користувача у правому куті меню та обрати Log Out.</p>
    </div>
</div>
<%@include file="html/footer" %>
</body>
</html>
