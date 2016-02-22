# filename: spec/spec_helper.rb
require 'selenium-webdriver'

RSpec.configure do |config|
    config.before(:each) do
        #@driver = Selenium::WebDriver.for :firefox
        @driver = Selenium::WebDriver.for :chrome
    end

    config.after(:each) do
        @driver.quit
    end
end
