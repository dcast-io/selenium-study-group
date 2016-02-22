# filename: login_spec.rb
require_relative 'spec_helper'
require_relative '../pages/login'

describe 'Login', :shallow do
    before(:each) do
        @login = Login.new(@driver)
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
