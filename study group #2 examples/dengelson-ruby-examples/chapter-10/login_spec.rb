# filename: login_spec.rb
require 'selenium-webdriver'
require_relative 'login'


describe 'Login' do

    before(:each) do
        #@driver = Selenium::WebDriver.for :firefox
        @driver = Selenium::WebDriver.for :chrome
        @login = Login.new(@driver)
    end

    after(:each) do
        @driver.quit
    end

    it 'succeeded' do
        @login.with('tomsmith', 'SuperSecretPassword!')
        expect(@login.success_message_present?).to eql true
    end

    it 'failed username' do
        @login.with('asdf', 'asdf')
        expect(@login.bad_username_message_present?).to eql true
    end

    it 'failed password' do
        @login.with('tomsmith', 'asdf')
        expect(@login.bad_password_message_present?).to eql true
    end

end
