# filename: login.rb
require_relative 'base_page'

class Login < BasePage
    LOGIN_FORM      = { id: 'login' }
    USERNAME_INPUT  = { id: 'username' }
    PASSWORD_INPUT  = { id: 'password' }
    SUBMIT_BUTTON   = { css: 'button'  }
    SUCCESS_MESSAGE = "You logged into a secure area!"
    BAD_USERNAME_MESSAGE = "Your username is invalid!"
    BAD_PASSWORD_MESSAGE = "Your password is invalid!"

    def initialize(driver)
        super
        visit 'http://the-internet.herokuapp.com/login'
        raise 'Login page not ready' unless
            is_displayed?(LOGIN_FORM)
    end

    def with(username, password)
        type username, USERNAME_INPUT
        type password, PASSWORD_INPUT
        click SUBMIT_BUTTON
    end

    def success_message_present?
        is_text_present? SUCCESS_MESSAGE
    end

    def bad_username_message_present?
        is_text_present? BAD_USERNAME_MESSAGE
    end

    def bad_password_message_present?
        is_text_present? BAD_PASSWORD_MESSAGE
    end
end
