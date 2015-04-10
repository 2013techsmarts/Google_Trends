package org.smarttechie;

import java.util.List;

import org.smarttechie.model.GoogleTrendItem;
import org.smarttechie.reader.GoogleTrendsReader;
import org.smarttechie.writer.GoogleTrendsWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class GoogleTrendsBatchConfiguration {

	@Bean
	public ItemReader<List<GoogleTrendItem>> reader() {
		GoogleTrendsReader reader = new GoogleTrendsReader();
		return reader;
	}

	@Bean
	public ItemWriter<List<GoogleTrendItem>> writer() {
		GoogleTrendsWriter writer = new GoogleTrendsWriter();
		return writer;
	}

	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<List<GoogleTrendItem>> reader,
			ItemWriter<List<GoogleTrendItem>> writer) {
		return stepBuilderFactory.get("step1")
				.<List<GoogleTrendItem>, List<GoogleTrendItem>> chunk(1)
				.reader(reader)
				.writer(writer)
				.build();
	}

	@Bean
	public Job importUserJob(JobBuilderFactory jobs, Step s1) {
		return jobs.get("importHotSeachesJob").preventRestart()
				.start(s1)
				.build();
	}
}
