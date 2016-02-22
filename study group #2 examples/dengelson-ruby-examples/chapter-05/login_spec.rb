# filename: login_spec.rb
require 'selenium-webdriver'

describe 'Login' do

    before(:each) do
        #@driver = Selenium::WebDriver.for :firefox
        @driver = Selenium::WebDriver.for :chrome
    end

    after(:each) do
        @driver.quit
    end

    it 'succeeded' do
        @driver.get 'http://the-internet.herokuapp.com/login'
        @driver.find_element(id: 'username').send_keys('tomsmith')
        @driver.find_element(id: 'password').send_keys('SuperSecretPassword!')
        @driver.find_element(css: 'button').submit
        expect(@driver.find_element(:tag_name, "html").text.include? "You logged into a secure area!").to eql true
    end

end
