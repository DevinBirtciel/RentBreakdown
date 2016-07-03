/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.devin.rent.model.email;

import java.io.ByteArrayInputStream;
// [START simple_includes]
import java.io.IOException;
// [START multipart_includes]
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
// [END simple_includes]
import javax.mail.internet.MimeMultipart;
// [END multipart_includes]
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailServlet extends HttpServlet {

	private static final long serialVersionUID = 413448653747197691L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String type = req.getParameter("type");
		if (type != null && type.equals("multipart")) {
			resp.getWriter().print("Sending HTML email with attachment.");
			sendMultipartMail(req);
		} else {
			resp.getWriter().print("Sending simple email.");
			sendSimpleMail(req);
		}
	}

	private void sendSimpleMail(HttpServletRequest req) {
		// [START simple_example]
		try {
			Message msg = setSimpleEmailFields(req);
			Transport.send(msg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// [END simple_example]
	}

	private void sendMultipartMail(HttpServletRequest req) {
		try {
			Message msg = setSimpleEmailFields(req);
			String filename = (String) req.getAttribute("filename");
			String mimeType = (String) req.getAttribute("mimeType");
			// [START multipart_example]
			byte[] attachmentData = null;
			Multipart mp = new MimeMultipart();

			MimeBodyPart attachment = new MimeBodyPart();
			InputStream attachmentDataStream = new ByteArrayInputStream(attachmentData);
			attachment.setFileName(filename);
			attachment.setContent(attachmentDataStream, mimeType);
			mp.addBodyPart(attachment);
			msg.setContent(mp);
			// [END multipart_example]
			Transport.send(msg);

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private Message setSimpleEmailFields(HttpServletRequest req) throws MessagingException, UnsupportedEncodingException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		String fromAddr = (String) req.getAttribute("fromAddr");
		String sender = (String) req.getAttribute("sender");
		@SuppressWarnings("unchecked")
		List<Recipient> recipients = (List<Recipient>) req.getAttribute("recipients");
		String message = (String) req.getAttribute("message");
		String subject = (String) req.getAttribute("subject");
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(fromAddr, sender));
		for(Recipient recipient : recipients){
			String toAddr = recipient.getAddr();
			String name = recipient.getName();
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddr, name));
		}
		msg.setSubject(subject);
		msg.setText(message);
		return msg;
	}
}