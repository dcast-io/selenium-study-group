# filename: config.rb
require 'sauce_whisk'

ENV['base_url']         ||= 'http://the-internet.herokuapp.com'
ENV['host']               = 'saucelabs'
ENV['SAUCE_USERNAME']     = 'YOUR_SAUCE_USERNAME'
ENV['SAUCE_ACCESS_KEY']   = 'YOUR_SAUCE_ACCESS_KEY'
ENV['operating_system'] ||= 'Windows XP'
ENV['browser']          ||= 'internet_explorer'
ENV['browser_version']  ||= '8'
