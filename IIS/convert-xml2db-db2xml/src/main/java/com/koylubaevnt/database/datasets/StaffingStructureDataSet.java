/**
 * 
 */
package com.koylubaevnt.database.datasets;

/**
 * <strong>Штатная структура</strong></br>
 * <code>StaffingStructureDataSet</code> - это DataSet класс, который хранит данные
 * необходимые полученные из БД или необходимые для записи в БД.
 * 
 * Структура класса повторяет струтуру таблицы в БД
 *  
 * @author KojlubaevNT
 *
 */
public class StaffingStructureDataSet {

	private int id = -1;
	private String depCode;
	private String depJob;
	private String description;
	
	/**
	 * Конструктор для создания DataSet сущности "Штатная структура"
	 * 
	 * @param id первичный ключ
	 * @param depCode код отдела
	 * @param depJob название должности в отделе
	 * @param description комментарий
	 */
	public StaffingStructureDataSet(int id, String depCode, String depJob, String description) {
		this.id = id;
		this.depCode = depCode.substring(0, Math.min(20, depCode.length()));
		this.depJob = depJob.substring(0, Math.min(100, depJob.length()));
		this.description = description.substring(0, Math.min(255, description.length()));
	}
	
	/**
	 * Конструктор для создания DataSet сущности "Штатная структура"
	 * 
	 * @param depCode код отдела
	 * @param depJob название должности в отделе
	 * @param description комментарий
	 */
	public StaffingStructureDataSet(String depCode, String depJob, String description) {
		this(-1, depCode, depJob, description);
	}
	
	/**
	 * Конструктор для создания DataSet сущности "Штатная структура"
	 * 
	 * @param depCode код отдела
	 * @param depJob название должности в отделе
	 */
	public StaffingStructureDataSet(String depCode, String depJob) {
		this(depCode, depJob, null);
	}
	
	/**
	 * Получение первичного ключа у сущности "Штатная структура"
	 * @return первичный ключ
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Получение кода отдела у сущности "Штатная структура"
	 * @return код отдела
	 */
	public String getDepCode() {
		return depCode;
	}

	/**
	 * Установка кода отдела для сущности "Штатная структура"
	 * @param depCode код отдела для установки
	 */
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	/**
	 * Получение название должности в отделе у сущности "Штатная структура"
	 * @return название должности в отделе
	 */
	public String getDepJob() {
		return depJob;
	}

	/**
	 * Установка названия должности в отделе для сущности "Штатная структура"
	 * @param depJob название должности в отделе для установки
	 */
	public void setDepJob(String depJob) {
		this.depJob = depJob;
	}

	/**
	 * Получение комментария у сущности "Штатная структура"
	 * @return комментарий
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Установка комментария для сущности "Штатная структура"
	 * @param description комментарий для установки
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depCode == null) ? 0 : depCode.hashCode());
		result = prime * result + ((depJob == null) ? 0 : depJob.hashCode());
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
		StaffingStructureDataSet other = (StaffingStructureDataSet) obj;
		if ((depCode == null && other.depCode != null) || !depCode.equals(other.depCode)) 
			return false;
		if ((depJob == null && other.depJob != null) || !depJob.equals(other.depJob))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StaffingStructureDataSet [id=" + id + ", depCode=" + depCode + ", depJob=" + depJob + ", description="
				+ description + "]";
	}
	
}
