# filename: spec/spec_helper.rb
require 'selenium-webdriver'

RSpec.configure do |config|
    config.before(:each) do
        case ENV['browser']
        when 'firefox'
            @driver = Selenium::WebDriver.for :firefox
        when 'chrome'
            @driver = Selenium::WebDriver.for :chrome
        end
    end

    config.after(:each) do
        @driver.quit
    end
end
