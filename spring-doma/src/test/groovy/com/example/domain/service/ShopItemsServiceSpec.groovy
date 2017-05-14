package com.example.domain.service;

import org.dbunit.DataSourceDatabaseTester
import org.dbunit.operation.DatabaseOperation
import org.dbunit.util.fileloader.CsvDataFileLoader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.ResourceUtils
import spock.lang.Specification
import spock.lang.Unroll

import javax.sql.DataSource

import com.example.domain.service.ShopItemsService;

@SpringBootTest
class ShopItemsServiceSpec extends Specification {

	@Autowired
	ShopItemsService shopItemsService;

	@Autowired
	DataSource dataSource

	def setup() {
		def databaseTester = new DataSourceDatabaseTester(dataSource)
		databaseTester.setUpOperation = DatabaseOperation.CLEAN_INSERT

		def loader = new CsvDataFileLoader()
		databaseTester.dataSet = loader.loadDataSet(ResourceUtils.getURL("classpath:dbunit/"))

		databaseTester.onSetup()
	}

	def "category service test"() {
		expect:
		def items = shopItemsService.getShopItems(1)

		items.each {
			println 'Shop ID: ' + it.shopId
			println 'Shop Name: ' + it.shopName
			println 'Item ID: ' + it.itemId
			println 'Item Name: ' + it.itemName
		}

		assert items.size() > 0
	}
}