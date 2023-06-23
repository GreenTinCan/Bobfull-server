package server.bobfull.infra.aws.s3.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import server.bobfull.infra.aws.s3.model.S3Image;

public interface AwsS3ImageRepository extends JpaRepository<S3Image,Long> {
}
