# filename: login.rb

class Login
    LOGIN_FORM      = { id: 'login' }
    USERNAME_INPUT  = { id: 'username' }
    PASSWORD_INPUT  = { id: 'password' }
    SUBMIT_BUTTON   = { css: 'button'  }
    SUCCESS_MESSAGE = "You logged into a secure area!"
    BAD_USERNAME_MESSAGE = "Your username is invalid!"
    BAD_PASSWORD_MESSAGE = "Your password is invalid!"

    def initialize(driver)
        @driver = driver
        @driver.get 'http://the-internet.herokuapp.com/login'
        raise 'Login page not ready' unless
            @driver.find_element(LOGIN_FORM).displayed?
    end

    def with(username, password)
        @driver.find_element(USERNAME_INPUT).send_keys(username)
        @driver.find_element(PASSWORD_INPUT).send_keys(password)
        @driver.find_element(SUBMIT_BUTTON).click
    end

    def success_message_present?
        @driver.find_element(:tag_name, "html").text.include? SUCCESS_MESSAGE
    end

    def bad_username_message_present?
        @driver.find_element(:tag_name, "html").text.include? BAD_USERNAME_MESSAGE
    end

    def bad_password_message_present?
        @driver.find_element(:tag_name, "html").text.include? BAD_PASSWORD_MESSAGE
    end
end
