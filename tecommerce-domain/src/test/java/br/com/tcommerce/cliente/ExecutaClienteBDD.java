package br.com.tcommerce.cliente;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/business/cliente.feature"})
public class ExecutaClienteBDD {

}
