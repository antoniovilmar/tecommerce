package br.com.tecommerce.domain.types;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

public class Data {

	private Calendar data;

	protected Data() {
	}

	private Data(Calendar data) {
		this.data = data;
	}

	private Data(String data) {
		this.data = stringParaCalendar(data);
	}

	public Calendar getData() {
		return data;
	}

	public Calendar getDataComHorasZeradas() {
		return getDataComMinutosZerados(getData());
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDataFormatada() {
		return calendarParaString(data);
	}

	public static Data instance() {
		return new Data();
	}

	public static Data instanceComCalendar() {
		return new Data(Calendar.getInstance());
	}

	public static Data instance(Calendar data) {
		Calendar notaData = (Calendar) data.clone();
		return new Data(notaData);
	}

	public static Data instance(String data) {
		return new Data(data);
	}

	public static Data instanceNoFuturo(Integer dataFutura) {
		Data data = Data.instanceComCalendar();
		data.getData().add(Calendar.DATE, dataFutura);
		return data;
	}

	public static Data instanceNoPassado(Integer dataPassada) {
		Data data = Data.instanceComCalendar();
		data.getData().add(Calendar.DATE, -dataPassada);
		return data;
	}

	public Integer getAno() {
		return data.get(Calendar.YEAR);
	}

	public Integer getMes() {
		return data.get(Calendar.MONTH);
	}

	public boolean isAntesDiaAtual() {
		if (getData() == null) {
			return false;
		}
		return getData().before(Calendar.getInstance());
	}

	public boolean isDiaAtualAntesQueData() {
		if (getData() == null) {
			return false;
		}
		return Calendar.getInstance().before(getData());
	}

	public boolean isDepoisDiaAtual() {
		if (getData() == null) {
			return false;
		}
		return getData().after(Calendar.getInstance());
	}

	public static Calendar getDataComMinutosZerados(Calendar calendar) {
		if (calendar == null) {
			return null;
		}
		Calendar minutosZerados = Calendar.getInstance();
		minutosZerados.setTime(calendar.getTime());
		minutosZerados.set(Calendar.HOUR_OF_DAY, 0);
		minutosZerados.set(Calendar.MINUTE, 0);
		minutosZerados.set(Calendar.SECOND, 0);
		minutosZerados.set(Calendar.MILLISECOND, 0);
		return minutosZerados;
	}

	public static Calendar getDataComMinutosNoCinquentaNove(Calendar calendar) {
		if (calendar == null) {
			return null;
		}
		Calendar horaNoFinal = Calendar.getInstance();
		horaNoFinal.setTime(calendar.getTime());
		horaNoFinal.set(Calendar.HOUR_OF_DAY, 23);
		horaNoFinal.set(Calendar.MINUTE, 59);
		horaNoFinal.set(Calendar.SECOND, 59);
		horaNoFinal.set(Calendar.MILLISECOND, 59);
		return horaNoFinal;
	}

	public static Calendar stringParaCalendarPatternT(String data) {
		if (data == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssXXX");
		try {
			calendar.setTime(sdf.parse(data));
			return calendar;
		} catch (ParseException e) {
			return stringParaCalendarPatternAno(data);
		}
	}

	public static Calendar stringParaCalendar(String data) {
		if (data == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			calendar.setTime(sdf.parse(data));
			return calendar;
		} catch (ParseException e) {
			return null;
		}
	}

	public static Calendar stringParaCalendarPatternAno(String data) {
		if (data == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			calendar.setTime(sdf.parse(data));
			return calendar;
		} catch (ParseException e) {
			return stringParaCalendar(data);
		}
	}

	public static String calendarParaString(Calendar calendar) {
		if (calendar == null) {
			return StringUtils.EMPTY;
		}
		return DateFormatUtils.format(calendar, "dd/MM/yyyy");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (getData() == null) {
			if (other.getData() != null)
				return false;
		} else if (!getDataComMinutosZerados(getData()).equals(getDataComMinutosZerados(other.getData())))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return calendarParaString(getData());
	}

}
