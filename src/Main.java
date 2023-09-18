import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import kotlin.BuilderInference;

import java.time.LocalTime;
import java.util.Locale;

public class Main {
    private static String firstName;

    public static void main(String[] args) {
        /*
        Done! Congratulations on your new bot. You will find it at t.me/VioletPermBot. You can now add a description,
        about section and profile picture for your bot, see /help for a list of commands. By the way, when you've
        finished creating your cool bot, ping our Bot Support if you want a better username for it. Just make sure
        the bot is fully operational before you do this.
        Use this token to access the HTTP API:
        6299689120:AAGxMPz8hMc3u0x0eJxdneF69T7wBgoGEaQ
        Keep your token secure and store it safely, it can be used by anyone to control your bot.
        For a description of the Bot API, see this page: https://core.telegram.org/bots/api
         */

        //6299689120:AAGxMPz8hMc3u0x0eJxdneF69T7wBgoGEaQ  VioletPermBot
        TelegramBot bot = new TelegramBot("6299689120:AAGxMPz8hMc3u0x0eJxdneF69T7wBgoGEaQ");



        bot.setUpdatesListener(updates -> {
            updates.forEach(update -> {
                try {


                    System.out.println(update);
                    long chatId = update.message().chat().id();

                    String incomeMessage = update.message().text();


                    String senderName = update.message().from().firstName(); // Считывает имя пользователя


                    //String massage = " Добро пожаловать, " + senderName;
                    //       приветствует пользователя
                    String massage = "";
                    LocalTime time = LocalTime.now();
                    int hour = time.getHour();
                    if (hour > 5 && hour < 12) {
                        massage = "Доброе утро, " + senderName + " !";
                    } else if (hour > 12 && hour < 18) {
                        massage = "Добрый день, " + senderName + " !";
                    } else if (hour > 18 && hour < 23) {
                        massage = "Добрый вечер, " + senderName + " !";
                    } else {
                        massage = "Доброй ночи, " + senderName + " !";
                    }


                    SendMessage request = new SendMessage(chatId, massage);
                    bot.execute(request);
                } catch (Exception exception){
                    exception.printStackTrace();
                }

            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}