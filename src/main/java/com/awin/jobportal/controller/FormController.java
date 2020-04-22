package com.awin.jobportal.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.awin.jobportal.dto.FormDto;
import com.awin.jobportal.service.FormService;
import com.awin.jobportal.service.UploadService;

@RestController
@RequestMapping("/")
public class FormController extends BaseController {
	@Autowired
	private FormService formService;
	@Autowired
	private UploadService uploadService;
	
	@ModelAttribute("formData")
	public FormDto getFormDto() {
		return new FormDto();
	}

	@GetMapping("")
	public ModelAndView showForm(@ModelAttribute("formData") FormDto formDto) {
		ModelAndView modelAndView = new ModelAndView("form");
		modelAndView.addObject("formData", new FormDto());
		return modelAndView;
	}

	@GetMapping(value = "uploadStatus")
	public ModelAndView showUploadStatus() {
		ModelAndView modelAndView = new ModelAndView("upload-status");
		return modelAndView;
	}

	@PostMapping(value = "upload/cv")
	public RedirectView uploadApplication(@Valid @ModelAttribute("formData") FormDto formDto,
			RedirectAttributes redirectAttributes) throws IOException {
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("/uploadStatus");

		if (formDto.getFile() == null || formDto.getFile().isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return redirectView;
		}

		uploadService.uploadFile(formDto.getFile());
		formService.registerApplication(formDto);

		redirectAttributes.addFlashAttribute("message", "Application submitted successfully!");
		return redirectView;
	}
}
