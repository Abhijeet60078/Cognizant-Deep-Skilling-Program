import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  const headingStyle = {
    color: cohort.status === 'ongoing' ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <h3 style={headingStyle}>{cohort.name}</h3>
      <dl>
        <dt>Mentor</dt>
        <dd>{cohort.mentor}</dd>
        <dt>Batch</dt>
        <dd>{cohort.batch}</dd>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Start Date</dt>
        <dd>{cohort.startDate}</dd>
        <dt>End Date</dt>
        <dd>{cohort.endDate}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
